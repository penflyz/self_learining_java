package com.hut.hashset_;

import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings({"ALL"})
public class Ex01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("xiaozhu", 21));
        hashSet.add(new Employee("xiaozhu", 21));
        hashSet.add(new Employee("xiaofu", 21));
        System.out.println(hashSet);
    }
}

class Employee{
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}