package com.hut.map_;

import javax.security.auth.login.FailedLoginException;
import java.util.*;

@SuppressWarnings({"all"})
public class Ex01 {
    public static void main(String[] args) {
        Map hashMap = new HashMap();
        hashMap.put(1, new Employee("dog", 100, 1));
        hashMap.put(2, new Employee("monk", 400, 2));
        hashMap.put(3, new Employee("pig", 300, 3));

        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            Employee employee = (Employee) hashMap.get(key);
            if (employee.getSal() > 200) {
                System.out.println(key + "号工人");
            }
        }

        Set set = hashMap.entrySet();
        for (Object o : set) {
            Map.Entry entry = (Map.Entry) o;
            Employee employee = (Employee) entry.getValue();
            if (employee.getSal() > 200) {
                System.out.println(employee.getId() + "号工人");
            }
        }

        Collection values = hashMap.values();
        for (Object o : values) {
            Employee employee = (Employee) o;
            if (employee.getSal() > 200) {
                System.out.println(employee.getId() + "号工人");
            }
        }
    }


    }

class Employee {
    private String name;
    private double sal;
    private int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}