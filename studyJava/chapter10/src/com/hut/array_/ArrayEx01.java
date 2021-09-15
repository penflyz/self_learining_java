package com.hut.array_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayEx01 {
    public static void main(String[] args) {
        int a[] = {1, 5, 6, 4, 10};
        ArrayWay.way(a, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer) o1;
                int i2 = (Integer) o2;
                return i1 - i2 ;
            }
        });

        System.out.println(Arrays.toString(a));


    }

}

class ArrayWay {
    public static void way(int a[], Comparator c) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (c.compare(a[i] , a[i + 1]) > 0) {
                    temp = a[i];
                    a[i + 1] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
}
