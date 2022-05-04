package com.example.thread.trace.bankBookSolved.core;

/**
 * packageName  :   com.example.thread.trace.bankBook
 * fileName     :   BankBook
 * author       :   sinabeuro53
 * date         :   2022-05-03
 * description  :
 */
public class BankBook {

    private int balance = 500;    // 남은 금액
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    // 입금
    public void deposit() {
        String name = Thread.currentThread().getName();
        threadLocal.set(balance);
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            threadLocal.set(threadLocal.get() + 400);
            System.out.println(name + " [입금] 남은 금액: " + threadLocal.get());
        }
    }

    // 출금
    public void withdraw() {
        String name = Thread.currentThread().getName();
        threadLocal.set(balance);
        while(true) {
            int randomMoney = (int) Math.ceil(Math.random() * 10)*100; // 100~1000 자연수
            if(threadLocal.get() >= randomMoney) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                balance = threadLocal.get() - randomMoney;
                threadLocal.set(balance);
                System.out.println(name + " [출금] 남은 금액: " + threadLocal.get());
            }
        }
    }
}
