package hut.tankgame;

import sun.awt.image.ToolkitImage;

import javax.sound.midi.SoundbankResource;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TreeMap;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    Vector<Node> nodes = null;
    int enemyTankSize = 6;
    //初始化敌军坦克
    Vector<EnemyTank> enemyTanks = new Vector<>();

    //初始化坦克
    MyTank myTank = null;
    Shot shot = null;
    //初始化炸弹
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    Vector<Bomb> bombs = new Vector<>();

    public MyPanel(int key) {

        if (Record.getRecordFile() != null) {
            nodes = Record.getNodesAndEnemyTankRec();
        }else {
            System.out.println("文件不存在，重启新游戏");
            key = 1;
        }
        Record.setEnemyTanks(enemyTanks);
        myTank = new MyTank(800, 500);
        myTank.setSpeed(8);
        myTank.setDirect(3);

        switch (key){
            case 1:
                //初始化敌方坦克 + 子弹
                for (int i = 0; i < enemyTankSize; i++) {
                    EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
                    enemyTank.setSpeed(5);
                    enemyTank.setDirect(2);
                    new Thread(enemyTank).start();
                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
                    new Thread(shot).start();
                    enemyTank.shots.add(shot);
                    new Thread(shot).start();
                    enemyTanks.add(enemyTank);
                    enemyTank.setEnemyTanks(enemyTanks);
                }
                break;
            case 2:

                //初始化敌方坦克 + 子弹
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);

                    EnemyTank enemyTank = new EnemyTank(node.getX(),node.getY());

                    enemyTank.setSpeed(5);

                    enemyTank.setDirect(node.getDirect());

                    new Thread(enemyTank).start();

                    Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());

                    new Thread(shot).start();

                    enemyTank.shots.add(shot);

                    new Thread(shot).start();

                    enemyTanks.add(enemyTank);

                    enemyTank.setEnemyTanks(enemyTanks);
                }
                break;
            default:

        }
        //实例化爆炸
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        new AePlayWave("d:\\myTemp\\111.wav").start();
    }

    public void showInfo(Graphics g) {

        //画出玩家的总成绩
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("您累积击毁敌方坦克", 1020, 30);
        drawTank(1020, 60, g, 0, 1);//画出一个敌方坦克
        g.setColor(Color.BLACK);//这里需要重新设置成黑色
        g.drawString(Record.getAllEnemyTankNum() + "", 1080, 100);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        showInfo(g);
        //默认黑色填充窗口
        g.fillRect(0, 0, 1000, 750);
        //画出坦克，封装方法
        if (myTank != null && myTank.isLive) {
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), 0);
        }

        //画出子弹
        for (int i = 0; i < myTank.shots.size(); i++) {
            Shot shot = myTank.shots.get(i);
            if (shot != null && shot.isLive) {
                g.fill3DRect(shot.x, shot.y, 2, 2, false);
            } else {
                myTank.shots.remove(shot);
            }
        }


        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);

            if (bomb.life > 6) {
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            }
            if (bomb.life > 4) {
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            bomb.lifeDown();

            if (bomb.life == 0) {
                bombs.remove(bomb);
            }
        }


        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);

            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);

                //画出敌方坦克的子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.isLive) {
                        g.fill3DRect(shot.x, shot.y, 2, 2, false);
                    } else {
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }

    }

    /**
     * @param x:坦克左上角x的位置
     * @param y：坦克左上角y的位置
     * @param g：画笔
     * @param direct：方向   0  1  2  3 上右下左
     * @param type：我0     敌1
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);  //左轮
                g.fill3DRect(x + 30, y, 10, 60, false);  //右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);   // 中间
                g.fillOval(x + 10, y + 20, 20, 20);  //圆盖
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);  //左轮
                g.fill3DRect(x, y + 30, 60, 10, false);  //右轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);   // 中间
                g.fillOval(x + 20, y + 10, 20, 20);  //圆盖
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);  //左轮
                g.fill3DRect(x + 30, y, 10, 60, false);  //右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);   // 中间
                g.fillOval(x + 10, y + 20, 20, 20);  //圆盖
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);  //左轮
                g.fill3DRect(x, y + 30, 60, 10, false);  //右轮
                g.fill3DRect(x + 10, y + 10, 40, 20, false);   // 中间
                g.fillOval(x + 20, y + 10, 20, 20);  //圆盖
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    public void hitEnemyTank() {
        if (myTank.shot != null && myTank.shot.isLive) {
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                hitTank(myTank.shot, enemyTank);
            }
        }
    }

    public void hitMyTank() {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (shot != null && shot.isLive) {
                    hitTank(shot, myTank);
                }
            }
        }
    }

    public void hitTank(Shot shot, Tank tank) {
        //判断s 击中坦克
        switch (tank.getDirect()) {
            case 0: //坦克向上
            case 2: //坦克向下
                if (shot.x > tank.getX() && shot.x < tank.getX() + 40
                        && shot.y > tank.getY() && shot.y < tank.getY() + 60) {
                    shot.isLive = false;
                    tank.isLive = false;
                    //当我的子弹击中敌人坦克后，将enemyTank 从Vector 拿掉
                    enemyTanks.remove(tank);
                    if (tank instanceof EnemyTank) {
                        Record.addAllEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1: //坦克向右
            case 3: //坦克向左
                if (shot.x > tank.getX() && shot.x < tank.getX() + 60
                        && shot.y > tank.getY() && shot.y < tank.getY() + 40) {
                    shot.isLive = false;
                    tank.isLive = false;

                    enemyTanks.remove(tank);
                    if (tank instanceof EnemyTank) {
                        Record.addAllEnemyTankNum();
                    }
                    Bomb bomb = new Bomb(tank.getX(), tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirect(0);
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirect(1);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirect(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirect(3);
            myTank.moveLeft();
        }

        //画子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {

            //一发子弹
//            if (myTank.shot == null || !myTank.shot.isLive) {
//                myTank.shotEnemyTank();
//            }
//            System.out.println("发射子弹");

            myTank.shotEnemyTank();
        }

        this.repaint();


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            hitEnemyTank();
            hitMyTank();
            this.repaint();
        }
    }

}
