package com.hut.homework;

public class HomeWork01  {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testwork(new Computer() {
            @Override
            public int work(int a, int b) {
                return a+b;
            }
        }, 1, 3);

    }
}

interface Computer{
    public int  work(int a,int b);
}

class CellPhone{
    public void testwork(Computer  computer,int a, int b) {
        int result =  computer.work(a,b);
        System.out.println(result);
    }
}
