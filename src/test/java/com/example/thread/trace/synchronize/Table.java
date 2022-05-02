package com.example.thread.trace.synchronize;

import java.util.ArrayList;

/**
 * packageName  :   com.example.thread.trace.synchronize
 * fileName     :   Table
 * author       :   sinabeuro53
 * data         :   2022-05-02
 * description  :
 */
public class Table {
    String[] dishNames = {"donut", "donut", "burger"};  // donut의 확률이 높인다.
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public synchronized void add(String dish) {
        while (dishes.size() >= MAX_FOOD) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is waiting.");
            try {
                wait();
                Thread.sleep(500);
            } catch (InterruptedException e) {}
        }
        dishes.add(dish);
        notify();
        System.out.println("Dishes:" + dishNames.toString());
    }

    public void remove(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();

            while (dishes.size() == 0) {
                System.out.println(name + " is waiting.");
                try {
                    wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }

            while (true) {
                for (int i=0; i<dishes.size();i++) {
                    if(dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notify();
                        return;
                    }
                } // for문의 끝
                try {
                    System.out.println(name + " is waiting.");
                    wait();
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
            }   // while(true)
        }   // synchronized
    }

    public int disNum() { return dishNames.length; }


}
