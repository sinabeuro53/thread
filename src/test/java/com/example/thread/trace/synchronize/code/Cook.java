package com.example.thread.trace.synchronize.code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * packageName  :   com.example.thread.trace.synchronize
 * fileName     :   Cook
 * author       :   sinabeuro53
 * data         :   2022-05-03
 * description  :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cook implements Runnable {
    private Table table;

    @Override
    public void run() {
        while (true) {
            int idx = (int) (Math.random() * table.disNum());    // 0~2
            table.add(table.dishNames[idx]);

            try { Thread.sleep(100);} catch (InterruptedException e) {}
        }   // while
    }
}
