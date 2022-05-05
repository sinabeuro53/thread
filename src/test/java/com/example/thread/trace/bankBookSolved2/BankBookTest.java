package com.example.thread.trace.bankBookSolved2;

import com.example.thread.trace.bankBookSolved2.core.BankBook;
import com.example.thread.trace.bankBookSolved2.core.DepositThread;
import com.example.thread.trace.bankBookSolved2.core.WithdrawThread;
import org.junit.jupiter.api.Test;

/**
 * packageName  :   com.example.thread.trace.bankBook
 * fileName     :   BankBook
 * author       :   sinabeuro53
 * date         :   2022-05-03
 * description  :
 */
public class BankBookTest {

    private BankBook bankBook = new BankBook();

    @Test
    public void test() throws InterruptedException {
        Thread depositThread = new Thread(new DepositThread(bankBook));
        depositThread.setName("deposit Thread  ");
        Thread withdrawThread1 = new Thread(new WithdrawThread(bankBook));
        withdrawThread1.setName("withdraw Thread1");
        Thread withdrawThread2 = new Thread(new WithdrawThread(bankBook));
        withdrawThread2.setName("withdraw Thread2");

        depositThread.start();
        withdrawThread1.start(); 
        Thread.sleep(100);
        withdrawThread2.start();

        Thread.sleep(2000);
    }
}
