package com.hut.polypara;

public class TestPara extends Employee {

    public TestPara(String name, int salary) {
        super(name, salary);
    }

    public String showAnnual(Employee e) {
        return e.getName() + "的年工资为" + e.getAnnual() + "元";
    }

    public String testWork(Employee e) {
        if (e instanceof Worker) {
            return ((Worker) e).work();
        } else if (e instanceof Manage) {
            return ((Manage) e).ManageWay();
        } else {
            return "不做处理";
        }
    }
}