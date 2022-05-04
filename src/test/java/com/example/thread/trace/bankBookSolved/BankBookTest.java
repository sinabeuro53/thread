package com.example.thread.trace.bankBookSolved;

import com.example.thread.trace.bankBookSolved.core.BankBook;
import com.example.thread.trace.bankBookSolved.core.DepositThread;
import com.example.thread.trace.bankBookSolved.core.WithdrawThread;
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
        Thread depositThread1 = new Thread(new DepositThread(bankBook));
        depositThread1.setName("deposit Thread1");
        Thread depositThread2 = new Thread(new DepositThread(bankBook));
        depositThread2.setName("deposit Thread2");
        Thread withdrawThread1 = new Thread(new WithdrawThread(bankBook));
        withdrawThread1.setName("withdraw Thread1");
        Thread withdrawThread2 = new Thread(new WithdrawThread(bankBook));
        withdrawThread2.setName("withdraw Thread2");

        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        Thread.sleep(100);
        withdrawThread2.start();

        Thread.sleep(2000);
    }
}
