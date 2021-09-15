package hut.else_;

import javax.swing.*;

/**
 * @param：
 * @author: Penflyz
 * @time: 2021/8/12 16:06
 */
public class Ex01 {
    public static void main(String[] args) {
        A a = new A();
        a.move(new A());
    }


}
interface B{
    int a = 0;
    public void run();
}

class A implements B{

    @Override
    public void run() {

    }

    public void move(B b){
        
    }
}

