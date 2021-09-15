package com.hut.innerclass;

import sun.util.resources.vi.CalendarData_vi;

public class InnerClass02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarm_clock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了。");
            }
        });
    }

}




interface Bell{
    void ring();
}

 class CellPhone{
    public void alarm_clock(Bell bell){
        bell.ring();
    }
}
