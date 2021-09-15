package com.hut.extends_;

public class extends011 extends extends01 {
    private String brand;

    public extends011(int CPU, int neiCun, int yingPan, String brand) {
        super(CPU, neiCun, yingPan);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
