package hut.draw;

import javax.swing.*;
import java.awt.*;

public class Draw  extends JFrame{ //JFrame对应窗口

    private MyPanel mp = null;

    public static void main(String[] args) {
        new Draw();
    }

    public Draw(){
        MyPanel myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1000, 750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}


//画板
class MyPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawOval(10, 10, 60, 60);


    }
}
