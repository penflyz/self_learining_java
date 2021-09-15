package com.hut.Test;

public class Test04 {
    public void run(){
        System.out.println("老大在跑步");
    }
    public void eat(){
        System.out.println("老大在吃饭");
    }
}

class Test004 extends Test04{
    public void run(){
        System.out.println("老二在跑步");
    }
    public void study(){
        System.out.println("老二在学习");
    }
}

class main_04{
    public static void main(String[] args) {
        Test004 test004 = new Test004();
        test004.run();
        Test04 test04 = new Test004();
        test004.run();
        test004.eat();
        Test004 t = (Test004)test004;
        t.eat();
    }
}
