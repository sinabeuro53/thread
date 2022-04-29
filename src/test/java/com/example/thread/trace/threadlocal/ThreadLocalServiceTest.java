package com.example.thread.trace.threadlocal;

import com.example.thread.trace.threadlocal.code.FieldService;
import com.example.thread.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * packageName  :   com.example.thread.trace.threadlocal.core
 * fileName     :   FieldServiceTest
 * author       :   sinabeuro53
 * data         :   2022-04-29
 * description  :
 */
@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService fieldService = new ThreadLocalService();

    @Test
    void field() {
        log.info("main start");

        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
//        sleep(2000);        // 동시성문제 발생X
        sleep(100);        // 동시성문제 발생O
        threadB.start();

        sleep(3000);        // 메인 쓰레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
