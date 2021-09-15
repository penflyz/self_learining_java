package com.hut.polyArr;

public class polyArr_ {
    public static void main(String[] args) {
        Person person[] = new Person[3];
        person[0] = new Person("老王", 20);
        person[1] = new Teacher("zhu", 20, 2000);
        person[2] = new Student("zhun", 12, 66);

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i].say());
            if (person[i] instanceof Teacher) {
                System.out.println(((Teacher) person[i]).move());
            } else if (person[i] instanceof Student) {
                System.out.println(((Student) person[i]).action());
            }
        }
    }
}
