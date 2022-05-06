package com.example.thread.trace.bankBookSolved.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * packageName  :   com.example.thread.trace.bankBook.core
 * fileName     :   withdrawThread
 * author       :   sinabeuro53
 * date         :   2022-05-03
 * description  :
 */
@Slf4j
@RequiredArgsConstructor
public class WithdrawThread implements Runnable {

    private final BankBook bankBook;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        log.info("{} (출금 스레드)", name);
        ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
        bankBook.withdraw(threadLocal);
        threadLocal.remove();
    }
}
