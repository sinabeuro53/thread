package com.example.thread.trace.bankBook.core;

/**
 * packageName  :   com.example.thread.trace.bankBook
 * fileName     :   BankBook
 * author       :   sinabeuro53
 * date         :   2022-05-03
 * description  :
 */
public class BankBook {

    int accountMoney = 0;
    
    // 출금
    public void withdraw() {
        int randomNumber = (int) Math.ceil(Math.random() * 10)*100; // 100~1000 자연수
        if(accountMoney > 0) {
            accountMoney -= randomNumber;
        }
        System.out.println("[출금] 남은 금액: " + accountMoney);
    }
    
    // 입금
    public void deposit() {
        accountMoney += 400;
        System.out.println("[입금] 남은 금액: " + accountMoney);
    }

}
