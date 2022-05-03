package com.example.thread.trace.synchronize;

import com.example.thread.trace.synchronize.code.Cook;
import com.example.thread.trace.synchronize.code.Customer;
import com.example.thread.trace.synchronize.code.Table;
import org.junit.jupiter.api.Test;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * packageName  :   com.example.thread.trace.synchronize.code
 * fileName     :   SynchronizedTest
 * author       :   sinabeuro53
 * data         :   2022-05-03
 * description  :
 */
public class SynchronizedTest {

//    @Autowired
    private Table table = new Table();

    @Test
    public void synchronizeTest() throws InterruptedException {
        ThreadGroup myGroup = new ThreadGroup("myGroup");

        Thread thread1 = new Thread(myGroup, new Cook(table), "COOK1");
        Thread thread2 = new Thread(myGroup, new Customer(table, "donut"), "CUST1");
        Thread thread3 = new Thread(myGroup, new Customer(table, "burger"), "CUST2");
        thread1.start();
        thread2.start();
        thread3.start();

        Hashtable hashtable = new Hashtable();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();


        Thread.sleep(5000);
//        System.exit(0);
    }
}
