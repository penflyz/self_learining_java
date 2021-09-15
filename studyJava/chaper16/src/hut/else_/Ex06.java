package hut.else_;

import sun.util.resources.cldr.br.CurrencyNames_br;

import java.util.concurrent.SynchronousQueue;

/**
 * @author: Penflyz
 * @time: 2021/8/16 11:03
 */
public class Ex06 {
    public static void main(String[] args) {
        A6 a6 = new A6();
        Thread thread = new Thread(a6);
        Thread thread1 = new Thread(a6);

        thread.start();
        thread1.start();

    }

}

class A6 implements Runnable{
    private static int money = 1000;
    @Override
    public void run() {
        while(true) {
            synchronized(this) {
                if (money == 0) {
                    System.out.println("您的余额不足");
                    break;
                }
                money -= 100;
                System.out.println(Thread.currentThread().getName() + "取出1000，还剩" + money);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}