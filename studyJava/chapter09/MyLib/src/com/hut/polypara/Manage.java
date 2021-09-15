package com.hut.polypara;

public class Manage extends Employee{
    private int bonus;

    public Manage(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public Manage(String name, int salary) {
        super(name, salary);
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public String ManageWay(){
        return super.getName()+"开始剥削人民啦！";
    }

    @Override
    public int getAnnual() {
        return super.getAnnual()+bonus;
    }
}
