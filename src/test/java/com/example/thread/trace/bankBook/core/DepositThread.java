package com.example.thread.trace.bankBook.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * packageName  :   com.example.thread.trace.bankBook.core
 * fileName     :   DepositThread
 * author       :   sinabeuro53
 * date         :   2022-05-03
 * description  :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class DepositThread implements Runnable {

    private BankBook bankBook;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while(true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {}

            log.info("{} (입금 스레드)", name);
            bankBook.deposit();
        }

    }
}
