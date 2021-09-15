package com.hut.array_;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayEx02 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("我是一头猪", 100.2);
        books[1] = new Book("我是好人", 200.4);
        books[2] = new Book("我", 5000.6);
        books[3] = new Book("你说什么就是什么", 10.66);

        Arrays.sort(books, new Comparator<Book>() {
                    @Override
                    public int compare(Book o1, Book o2) {
                        return o1.getPrice() - o2.getPrice()>0?-1:1;
                    }
                }
        );
        
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }

    }
}

class Book {
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
