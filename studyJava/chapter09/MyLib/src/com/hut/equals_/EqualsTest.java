package com.hut.equals_;

public class EqualsTest {
    public static void main(String[] args) {
        Person fei = new Person("fei", 18);
        Person fei1 = new Person("fei", 18);
        System.out.println(fei.equals(fei1));
    }
}

class Person{
    String name;
    int age;

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        else if (obj instanceof Person){
            if(this.name == ((Person) obj).name && this.age==((Person) obj).age){
                return true;
            }else {return false;}

        }else {return false;}
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

