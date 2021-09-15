package com.hut.Test;

import java.util.Scanner;


public class test02 {
    private double balance;

    public test02(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void earnMonthlyInterest() {

    }
}

class CheckingAccount extends test02 {
    public int account;

    public CheckingAccount(double initialBalance) {
        super(initialBalance);
    }

    public void deposit(double amount) {
        if (account % 3 != 0) {
            super.deposit(amount - 1);
        } else {
            super.deposit(amount);
        }
        account += 1;
    }

    public void withdraw(double amount) {
        if (amount % 3 != 0) {
            super.withdraw(amount + 1);
        } else {
            super.deposit(amount);
        }
        account += 1;
    }
}

class main_ {

    public static void main(String[] args) {
        do {
            CheckingAccount checkingAccount = new CheckingAccount(500);
            checkingAccount.deposit(10);
            checkingAccount.withdraw(100);
            double balance = checkingAccount.getBalance();
            System.out.println("第"+checkingAccount.account+"次操作"+"\t"+"balance="+balance );
            Scanner scanner = new Scanner(System.in);
            System.out.println("您是否要退出（y/n）：");
            String choice = scanner.next();
            if ("y".equals(choice)) {
                break;
            }
        }while (true);

    }
}


