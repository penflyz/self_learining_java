package com.hut.polypara;

public class PolyPara {
    public static void main(String[] args) {
        Worker dazhun = new Worker("dazhun", 50);
        Manage feige = new Manage("feige", 10000,6666);

        System.out.println(dazhun.getAnnual());
        System.out.println(feige.getAnnual());

        System.out.println("=========分界线========");
        TestPara feige1 = new TestPara("feige", 6666);
        TestPara dazhun1 = new TestPara("dazhun", 20);
        System.out.println(feige1.showAnnual(feige1));
        System.out.println(dazhun1.showAnnual(dazhun1));

        System.out.println(dazhun1.testWork(dazhun));
        System.out.println(feige1.testWork(feige));

    }
}
