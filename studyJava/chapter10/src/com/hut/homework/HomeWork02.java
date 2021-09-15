package com.hut.homework;

import javax.crypto.spec.IvParameterSpec;

public class HomeWork02 {
    public static void main(String[] args) {
        Person tang = new Person("唐僧", new Horse());
        tang.passRiver();
        tang.passRiver();
        tang.passRoad();
        tang.passRoad();
        tang.passMount();

    }
}

interface Vehicles{
    void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("小马跑得快");
    }
}

class Board implements Vehicles{
    @Override
    public void work() {
        System.out.println("小船游啊游");
    }
}

class Air implements Vehicles{
    @Override
    public void work() {
        System.out.println("飞机飞呀飞");
    }
}


class plant{

    private plant(){};

    private static Horse horse = new Horse(); // 饿汉式

    public static Horse getHorse(){
        return horse;
    }

    public static Air getAir(){
        return new Air();
    }

    public static Board getBoard(){
        return new Board();
    }
}

class Person{
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passRiver(){
        if (!(vehicles instanceof Board)){
            vehicles = plant.getBoard();
        }
        vehicles.work();
    }

    public void passRoad() {
        if (!(vehicles instanceof Horse)){
            vehicles = plant.getHorse();
        }

        vehicles.work();

    }

    public void passMount() {
        if (!(vehicles instanceof Air)){
            vehicles = plant.getAir();
        }
        vehicles.work();

    }
}