package com.hut.excise;

import java.util.ArrayList;

public class EX02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        car baoma = new car("baoma", 100);
        arrayList.add(baoma);
        car benchi = new car("benchi", 200);
        arrayList.add(benchi);
        arrayList.remove(benchi);
        System.out.println(arrayList);
        System.out.println(arrayList.contains(baoma));
        System.out.println(arrayList.size());


    }
}


class car{
    private String name;
    private int price;

    public car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}