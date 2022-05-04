package com.example.thread.trace.bankBook.core;

/**
 * packageName  :   com.example.thread.trace.bankBook
 * fileName     :   BankBook
 * author       :   sinabeuro53
 * date         :   2022-05-03
 * description  :
 */
public class BankBook {

    private int balance = 0;    // 남은 금액

    // 입금
    public void deposit() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            balance += 400;
            System.out.println("[입금] 남은 금액: " + balance);
        }
    }

    // 출금
    public void withdraw() {
        while(true) {
            int randomMoney = (int) Math.ceil(Math.random() * 10)*100; // 100~1000 자연수
            if(balance >= randomMoney) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                balance -= randomMoney;
                System.out.println("[출금] 남은 금액: " + balance);
            }
        }
    }
}
