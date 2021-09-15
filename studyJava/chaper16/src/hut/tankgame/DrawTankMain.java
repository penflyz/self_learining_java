package hut.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Scanner;

public class DrawTankMain extends JFrame {

    private DrawTankMain myPanel = null;
    private Scanner scanner = new Scanner(System.in) ;
    public static void main(String[] args) throws IOException {
        new DrawTankMain();
    }

    public DrawTankMain() throws IOException {
        System.out.println("请输入选择 1: 新游戏 2: 继续上局");
        int key = scanner.nextInt();

        MyPanel myPanel = new MyPanel(key);
        this.add(myPanel);

        Thread thread = new Thread(myPanel);
        thread.start();

        this.setSize(1300, 750);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Record.keepRecord();
                System.exit(0);
            }
        });


        this.setVisible(true);
    }

}
