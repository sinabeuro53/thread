package com.example.thread.trace.synchronize;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * packageName  :   com.example.thread.trace.synchronize
 * fileName     :   Customer
 * author       :   sinabeuro53
 * data         :   2022-05-02
 * description  :
 */
@Data
@AllArgsConstructor
public class Customer implements Runnable {
    private Table table;
    private String food;

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}

            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food);
        }   // while
    }
}
