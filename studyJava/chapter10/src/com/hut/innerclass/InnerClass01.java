package com.hut.innerclass;

public class InnerClass01 {
    public static void main(String[] args) {

        f1(new AI() {
            @Override
            public void face() {
                System.out.println("我是猪");
            }
        });

    }

    public static void f1(AI ai){
        ai.face();
    }

}

interface  AI{
    public void face();
}