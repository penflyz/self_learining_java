package com.hut.Test;

public class Test03 {
    private int x;
    private int y;

    public Test03(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class LabelPoint extends Test03 {
    private String label;

    public LabelPoint(int x, int y, String label) {
        super(x, y);
        this.label = label;
    }
}
