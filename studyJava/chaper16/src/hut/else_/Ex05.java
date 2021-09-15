package hut.else_;


import com.sun.xml.internal.fastinfoset.util.ValueArrayResourceException;

import java.util.Random;
import java.util.Scanner;


/**
 * @author: Penflyz
 * @time: 2021/8/16 9:27
 */
public class Ex05 {
    public static void main(String[] args) {
        A5 a5 = new A5();

        B5 b5 = new B5(a5);
        Thread thread = new Thread(a5);
        Thread thread1 = new Thread(b5);

        thread.start();
        thread1.start();

    }

}

class A5 extends Thread{
    private static boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop){
            Random random = new Random();
            int rand = random.nextInt(100);
            System.out.println(rand);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B5 extends Thread  {

    private  A5 a;
    Scanner scanner = new Scanner(System.in);


    public B5(A5 a){
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("请问您是否退出（Q）：");
        char key = scanner.next().toUpperCase().charAt(0);
        if (key == 'Q'){
            a.setLoop(false);
            System.out.println("A进程结束");
        }

    }
}