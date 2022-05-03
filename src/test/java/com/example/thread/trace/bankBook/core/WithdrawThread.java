package com.example.thread.trace.bankBook.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * packageName  :   com.example.thread.trace.bankBook.core
 * fileName     :   withdrawThread
 * author       :   sinabeuro53
 * date         :   2022-05-03
 * description  :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class WithdrawThread implements Runnable {

    private BankBook bankBook;
    private String name = Thread.currentThread().getName();

    public WithdrawThread(BankBook bankBook) {
        this.bankBook = bankBook;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {}

            log.info("{} (출금 스레드)", name);
            bankBook.withdraw();
        }
    }
}
