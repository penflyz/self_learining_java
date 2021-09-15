package hut.else_;

/**
 * @author: Penflyz
 * @time: 2021/8/13 14:48
 */
public class Ex03 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        Thread thread = new Thread(t);
        thread.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("hi" + i );

            if (i == 5 ){

                thread.join();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }


}

class T implements Runnable {
    private int count = 20;

    @Override
    public void run() {

        while (true) {
            System.out.println("hello" + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (--count == 0){
                break;
            }
        }
    }
}