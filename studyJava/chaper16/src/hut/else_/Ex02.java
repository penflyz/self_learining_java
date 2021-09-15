package hut.else_;

import javax.security.auth.login.AccountException;

/**
 *
 * @author: Penflyz
 * @time: 2021/8/12 16:37
 *
 */
public class Ex02 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Thread thread = new Thread(dog);
        Thread thread1 = new Thread(cat);
        thread.start();
        thread1.start();
    }
}

class Dog implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("小狗汪汪叫..."+count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (++count == 50){
                break;
            }
        }
    }
}

class Cat implements Runnable {
    private int count = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println("小猫喵喵叫..."+ count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (++count == 50){
                break;
            }
        }
    }
}