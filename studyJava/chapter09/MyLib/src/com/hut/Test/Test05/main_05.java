package com.hut.Test.Test05;

public class main_05 {
    public static void main(String[] args) {
        main_05 main_05 = new main_05();
        Person p[] = new Person[4];
        p[0] = new Teacher("zhu", "w", 45, 23);
        p[1] = new Teacher("peng", "nan", 23, 3);
        p[2] = new Student("fu", "w", 35, 8);
        p[3] = new Student("JIA", "NAN", 24, 5);
        Person temp = null;
        for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p.length - 1 - i; j++) {
                if (p[j].getAge() < p[j + 1].getAge()) {
                    temp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i <p.length ; i++) {
            System.out.println(p[i]);

        }

        for (int i = 0; i < p.length; i++) {
            main_05.test(p[i]);

        }
    }

    public void test(Person p) {
        if (p instanceof Student) {
            ((Student) p).study();
        }
        if (p instanceof Teacher) {
            ((Teacher) p).teach();
        }
    }
}


