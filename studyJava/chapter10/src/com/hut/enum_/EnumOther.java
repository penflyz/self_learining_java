package com.hut.enum_;

public class EnumOther {
    public static void main(String[] args) {
        a aa = new a();
        System.out.println(aa);
    }
}

class a{
    private int aaa;

    @Override
    public String toString() {
        return "a{" +
                "aaa=" + aaa +
                '}';
    }
}
