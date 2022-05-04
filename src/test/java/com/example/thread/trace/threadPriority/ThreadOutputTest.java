package com.example.thread.trace.threadPriority;

import com.example.thread.trace.threadPriority.core.ThreadOutput1;
import com.example.thread.trace.threadPriority.core.ThreadOutput2;
import org.junit.jupiter.api.Test;

/**
 * packageName  :   com.example.thread.trace.threadPriority.core
 * fileName     :   ThreadTest
 * author       :   sinabeuro53
 * date         :   2022-05-04
 * description  :
 */
public class ThreadOutputTest {

    @Test
    public void test() {
        Thread thread1 = new Thread(new ThreadOutput1());
        Thread thread2 = new Thread(new ThreadOutput2());
        thread1.setPriority(7);
        thread1.start();
        thread2.start();
    }

}
