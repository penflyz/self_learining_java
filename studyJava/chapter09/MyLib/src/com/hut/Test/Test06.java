package com.hut.Test;

public class Test06 {
    public static void main(String[] args) {
        C c = new C();// 1. 转到c无参构造器
    }
}
class A{ //超类
    public A(){
        System.out.println("我是A类");
    } // 5. 最后一步。
}
class B extends A{
    public B(){
        System.out.println("我是b类的无参构造");
    }
    public B(String name){
        //super()
        System.out.println(name+"我是b类的有参构造");// 4.构造器默认继承上级的无参构造器， 转到a无参。
    }
}
class C extends B{
    public C(){
        this("hello");//2. 转到c有参构造
        System.out.println("我是c类无参构造器");
    }
    public C(String name){
        super("haha"); //3. 转到b有参
        System.out.println("我是c类有参构造");
    }
}