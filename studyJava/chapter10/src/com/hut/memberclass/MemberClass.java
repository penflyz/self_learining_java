package com.hut.memberclass;

public class MemberClass {
    public static void main(String[] args) {
        outer.inner1 inner = new outer().getInner();
        inner.say();
        System.out.println(inner);
    }
}

class outer{
    private int s;
    public class inner1{
        public void say(){
            System.out.println("我是猪");
        }
    }

    public inner1 getInner(){
        return new inner1();
    }

    @Override
    public String toString() {
        return "outer{" +
                "s=" + s +
                '}';
    }
}