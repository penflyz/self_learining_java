package com.hut.generics_;

import java.util.ArrayList;
import java.util.Comparator;

public class Ex02 {
    public static void main(String[] args) {
        Employee zhu = new Employee("zhu", 1222,
                new MyDate(1997, 10, 28));
        Employee fu = new Employee("fu", 5433,
                new MyDate(2000, 1, 14));
        Employee liu = new Employee("fu", 478,
                new MyDate(4245, 7, 18));

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(zhu);
        employees.add(fu);
        employees.add(liu);

        employees.sort(new Comparator<Employee>() {
                           @Override
                           public int compare(Employee o1, Employee o2) {
                               int i = o1.getName().compareTo(o2.getName());
                               if(i  != 0 ){
                                   return i;
                               }

                               return o1.getBirthday().compareTo(o2.getBirthday());

                           }
                       }
        );
        for (Employee o :employees) {
            System.out.println(o);
        }


    }
}

class Employee {
    private String name;
    private int sal;

    private MyDate birthday;


    public Employee(String name, int sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }


    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int mon;
    private int day;

    public MyDate(int year, int mon, int day) {
        this.year = year;
        this.mon = mon;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                "-" + mon +
                "-" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {

        int i = year - o.year;
        return year;
    }
}