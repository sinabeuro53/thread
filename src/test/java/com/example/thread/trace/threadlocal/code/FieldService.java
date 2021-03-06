package com.example.thread.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;

/**
 * packageName  :   com.example.thread.trace.threadlocal.core
 * fileName     :   FieldService
 * author       :   sinabeuro53
 * data         :   2022-04-29
 * description  :
 */
@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name) {
        log.info("์ ์ฅ name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("์กฐํ nameStore={}", nameStore);
        return nameStore;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
