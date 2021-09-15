package com.hut.smallchargesys.classic;
//面向过程
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallCharge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        Date data = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        //收益
        double income = 0;
        double balance = 0;
        String detail = "===============零钱通明细===============\n";

        //支出
        double outcome = 0;
        String consumeType = " ";

        //退出
        String choice = " ";

        do {
            System.out.println("===========零钱通菜单==========");
            System.out.println("\t\t1  零钱通明细");
            System.out.println("\t\t2  收益入账");
            System.out.println("\t\t3  消费");
            System.out.println("\t\t4  退出");
            System.out.println("请输入您的选择[1-4]:");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println(detail);
                    break;
                case 2:
                    System.out.println("请输入您的收益金额：");
                    income = scanner.nextDouble();
                    balance += income;

                    System.out.println("您的收益" + income + "已经存入零钱通");
                    detail += "收益入账\t" + income + "\t" + sdf.format(data) + "\t余额" + balance + "\n";
                    break;
                case 3:
                    System.out.println("请输入消费金额：");
                    while (true) {
                        outcome = scanner.nextDouble();
                        if (outcome > balance) {
                            System.out.println("穷逼，你没有那么多钱！");
                            System.out.println("请重新输入消费金额:");
                        }else {
                            break;
                        }
                    }
                    System.out.println("请输入消费类型：");
                    consumeType = scanner.next();
                    System.out.println("您的消费" + outcome + "已经记录完毕");
                    balance -= outcome;
                    detail += consumeType + "\t" + outcome + "\t" + sdf.format(data) + "\t余额" + balance + "\n";
                    break;
                case 4:
                    System.out.println("您是否确认退出零钱通？（y/n）");
                    while (true) {
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        } else {
                            System.out.println("输入错误请重新输入（y/n）");
                        }
                    }
                    if ("y".equals(choice)) {
                        System.out.println("您已退出零钱通系统");
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("您输入有误");
            }

        } while (loop);
    }
}

