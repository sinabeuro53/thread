package com.example.thread.trace.bankBook;

import com.example.thread.trace.bankBook.core.BankBook;
import com.example.thread.trace.bankBook.core.DepositThread;
import com.example.thread.trace.bankBook.core.WithdrawThread;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        Thread thread1 = new Thread(new DepositThread(bankBook));
        thread1.setName("deposit Thread");
        Thread thread2 = new Thread(new WithdrawThread(bankBook));
        thread2.setName("withdraw Thread");

        thread1.start();
        thread2.start();

        Thread.sleep(2000);
    }
}
