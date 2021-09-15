package com.hut.polypara;

public class Worker extends Employee{
    public Worker(String name, int salary) {
        super(name, salary);
    }
    public String work(){
        return getName()+"正在被剥削";
    }
}
