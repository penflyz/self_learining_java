package com.hut.house_sys.service;

import com.hut.house_sys.house.House;
import org.omg.CORBA.PUBLIC_MEMBER;

public class HouseService {

    private int size;
    private House[] houses;
    private int houseNum = 1;
    private int idCount = 1;
    private int delIndex = -1;
    private int findIndex = -1;
    private int updateID;

    public House[] getHouses() {
        return houses;
    }

    public int getFindIndex() {
        return findIndex;
    }

//更改信息

    public House update(int updateID ,String name,String phone ,String address ,int rent ,String state){
        houses[updateID].setName(name);
        houses[updateID].setPhone(phone);
        houses[updateID].setAddress(address);
        houses[updateID].setRent(rent);
        houses[updateID].setState(state);
        return houses[updateID];
    }

    //查找信息
    public boolean find(int findID) {

        for (int i = 0; i < houseNum; i++) {
            if (findID == houses[i].getId()) {
                findIndex = i;
                System.out.println(houses[findIndex].toString());
                return true;
            }
        }
        return false;
    }

    //删除房屋信息
    public boolean del(int delID) {
        if (delID > houseNum) {
            return false;
        }

        for (int i = 0; i < houseNum; i++) {
            if (delID == houses[i].getId()) {
                delIndex = i;
            }
        }
        if (delIndex == -1) {
//            System.out.println("房子不存在，删除房子失败。");
            return false;
        }
        for (int i = delIndex; i < houseNum - 1; i++) {
            houses[i] = houses[i + 1];
        }
        houses[--houseNum] = null;
//        System.out.println("您已成功删除房子。");
        return true;
    }

    //添加房屋信息方法
    public boolean add(House newHouse) {
        if (houseNum == houses.length) {
            System.out.println("数组已满，不能在添加了");
            return false;
        }
        houses[houseNum++] = newHouse;
        newHouse.setId(++idCount);

        return true;
    }

    //显示房屋列表方法
    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(1, "fei", "123", "长沙", 20, "未出租");
    }

    public House[] list() {
        return houses;
    }
}
