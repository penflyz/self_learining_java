package com.hut.Test;

public class Test01 {
    public static void main(String[] args) {
        Person person[] = new Person[3];
        person[0] = new Person("zhu", 12, "shi");
        person[1] = new Person("fu", 13, "gou");
        person[2] = new Person("wei", 14, "hai");

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }

        Person temp = null;
        for (int i = 0; i < person.length-1; i++) {
//            System.out.println(person[i]);
            for (int j = 0; j < person.length-i-1; j++) {
                if(person[j].age < person[j + 1 ].age){
                    temp = person[j];
                    person[j] = person[j+1];
                    person[j+1] = temp ;
                }
            }
        }

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
        }
    }

}
class Person{
    String name;
    int age;
    String jop;
    public Person(String name, int age, String jop) {
        this.name = name;
        this.age = age;
        this.jop = jop;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", jop='" + jop + '\'' +
                '}';
    }
}
