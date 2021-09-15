package hut.else_;

/**
 * @author: Penflyz
 * @time: 2021/8/13 16:15
 */
public class Ex04 {
    public static void main(String[] args) throws InterruptedException {
        T4 t4 = new T4();
        Thread thread = new Thread(t4);
        Thread thread1 = new Thread(t4);
        Thread thread2 = new Thread(t4 );
        thread.start();
        thread1.start();
        thread2.start();

    }


}

class T4 implements Runnable {
    private  int  count = 30;
    private boolean bool = true;

    public synchronized void m(){


        if (count <= 0 ){
            System.out.println("售票结束");
            bool = false;
            return;
        }

        System.out.println(Thread.currentThread().getName()+"在卖票"+"剩余票数"+(--count));

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (bool) {
            m();
        }
    }
}