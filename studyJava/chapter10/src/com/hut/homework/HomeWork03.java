package com.hut.homework;

public class HomeWork03 {
    public static void main(String[] args) {
        Car.Air air = new Car(20).getAir();
        air.flow();
    }
}
class Car{
    private int temperature;

    public Car(int temperature) {
        this.temperature = temperature;
    }
    class Air{
        public void flow(){
            if (temperature>40){
                System.out.println("吹冷风");
            }
            else if(temperature<0){
                System.out.println("吹暖风");
            }else{
                System.out.println("关掉空调");
            }
        }
    }
    public Air getAir(){
        Air air = new Air();
        return air;
    }

}