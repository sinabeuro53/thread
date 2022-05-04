package com.example.thread.trace.bankBookSolved2.core;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName  :   com.example.thread.trace.bankBook
 * fileName     :   BankBook
 * author       :   sinabeuro53
 * date         :   2022-05-03
 * description  :
 */
@Slf4j
public class BankBook {

    private int balance = 0;    // 남은 금액

    // 입금
    public void deposit() {
        String name = Thread.currentThread().getName();
        while(true) {
            synchronized (this) {
                try {
                    Thread.sleep(100);
                    balance += 400;
                    wait();
                } catch (InterruptedException e) {}

                System.out.println(name + " [입금] 남은 금액: " + balance);
            }
        }
    }

    // 출금
    public void withdraw() {
        String name = Thread.currentThread().getName();
        while(true) {
            synchronized (this) {
                int randomMoney = (int) Math.ceil(Math.random() * 10)*100; // 100~1000 자연수
                if(balance >= randomMoney) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    balance -= randomMoney;
                    System.out.println(name + " [출금] 남은 금액: " + balance);
                } else {
                    notifyAll();
                }
            }
        }
    }
}
