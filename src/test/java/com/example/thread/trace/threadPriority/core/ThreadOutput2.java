package com.example.thread.trace.threadPriority.core;

/**
 * packageName  :   com.example.thread.trace.threadPriority.core
 * fileName     :   ThreadOuput1
 * author       :   sinabeuro53
 * date         :   2022-05-04
 * description  :
 */
public class ThreadOutput2 implements Runnable {

    @Override
    public void run() {
        for (int i=0; i < 20; i++)
            System.out.println("|");
    }
}
