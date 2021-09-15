package com.hut.extends_;

public class extends01 {
    private int CPU;
    private int NeiCun;
    private int YingPan;

    public extends01(int CPU, int neiCun, int yingPan) {
        this.CPU = CPU;
        this.NeiCun = neiCun;
        this.YingPan = yingPan;
    }

    public int getCPU() {
        return CPU;
    }

    public void setCPU(int CPU) {
        this.CPU = CPU;
    }

    public int getNeiCun() {
        return NeiCun;
    }

    public void setNeiCun(int neiCun) {
        NeiCun = neiCun;
    }

    public int getYingPan() {
        return YingPan;
    }

    public void setYingPan(int yingPan) {
        YingPan = yingPan;
    }

    public String getDetails(){
        return "cpu:"+CPU+"\t"+"neicun:"+NeiCun+"\t"+"YingPan:"+YingPan;
    }
}
