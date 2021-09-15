package com.hut.house_sys.view;

import com.hut.house_sys.house.House;
import com.hut.house_sys.service.HouseService;
import com.hut.house_sys.utils.Utility;

public class HouseView {

    private HouseService houseService = new HouseService(2);

    public void updateHouse(){
        System.out.println("===========修改房屋==========");
        System.out.println("请选择待修改的房屋编号（-1 退出）：");
        int updateID = Utility.readInt();
        if (updateID == -1) {
            System.out.println("您已成功退出");
            return;
        }
        if (houseService.find(updateID)) {
            System.out.print("姓名" + "(" + houseService.getHouses()[houseService.getFindIndex()].getName() + "):");
            String updateName = Utility.readString(10);
            System.out.print("电话" + "(" + houseService.getHouses()[houseService.getFindIndex()].getPhone() + "):");
            String updatePhone = Utility.readString(10);
            System.out.print("地址" + "(" + houseService.getHouses()[houseService.getFindIndex()].getAddress() + "):");
            String updateAddress = Utility.readString(10);
            System.out.print("租金" + "(" + houseService.getHouses()[houseService.getFindIndex()].getRent() + "):");
            int updateRent = Utility.readInt(10);
            System.out.print("状态" + "(" + houseService.getHouses()[houseService.getFindIndex()].getState() + "):");
            String updateState = Utility.readString(10);
            houseService.update(houseService.getFindIndex(), updateName, updatePhone,updateAddress ,updateRent,updateState);
            System.out.println("修改完成");
        }else{
            System.out.println("未查到相关信息，修改失败。");
        }

    }

    //查找
    public void findHouse(){
        int findID;

        System.out.println("=================查找房屋===============");
        System.out.print("请输入你要查找的id：");
        findID = Utility.readInt();
        if (houseService.find(findID)){
            System.out.println("查找成功");
        }else {
            System.out.println("未查找到该房间");
        }

    }


    //退出系统
    public void exitHouse() {
        char exit;
        exit = Utility.readConfirmSelection();
        if (exit == 'Y') {
            loop = false;
        }
    }


    public void delHouse() {
        System.out.println("===================删除房屋==============");
        System.out.println("请选择待删除的房屋编号（-1 退出）：");
        int delID = Utility.readInt();
        if (delID == -1) {
            System.out.println("您已成功退出");
            return;
        }
        char delChoose = Utility.readConfirmSelection();
        if (delChoose == 'Y') {
            if (houseService.del(delID)) {
                System.out.println("您已成功删除房子");
            } else {
                System.out.println("房子不存在，删除房子失败。");
            }
        } else {
            System.out.println("您已取消删除");
        }
    }


    public void addHouse() {
        System.out.println("================添加房屋=================");
        System.out.print("姓名:");
        String name = Utility.readString(8);
        System.out.print("电话:");
        String phone = Utility.readString(8);
        System.out.print("地址：");
        String address = Utility.readString(8);
        System.out.print("月租：");
        int rent = Utility.readInt(8);
        System.out.print("状态：");
        String state = Utility.readString(8);

        House newHouse = new House(0, name, phone, address, rent, state);

        if (houseService.add(newHouse)) {
            System.out.println("房屋添加成功");
        } else {
            System.out.println("房屋添加失败");
        }
    }


    public void listHouses() {
        System.out.println("================房屋列表=================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("===============房屋列表展示完毕===========");
    }

    private boolean loop = true;
    private int key;

    public void mainMenu() {
        do {
            System.out.println("================房屋出租系统==============");
            System.out.println("\t\t\t1  新 增 房 源");
            System.out.println("\t\t\t2  查 找 房 源");
            System.out.println("\t\t\t3  删 除 房 源");
            System.out.println("\t\t\t4  修 改 房 源 信 息");
            System.out.println("\t\t\t5  房 源 列 表");
            System.out.println("\t\t\t6  退       出");
            System.out.println("请输入你的选择：");
            key = Utility.readInt();
            switch (key) {
                case 1:
                    this.addHouse();
                    break;
                case 2:
                    this.findHouse();
                    break;
                case 3:
                    this.delHouse();
                    break;
                case 4:
                    this.updateHouse();
                    break;
                case 5:
                    this.listHouses();
                    break;
                case 6:
                    this.exitHouse();
                    break;
            }
        } while (loop);
    }
}
