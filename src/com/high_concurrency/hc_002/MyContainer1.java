package com.high_concurrency.hc_002;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by thinkpad on 2018/4/6.
 * <p>
 * 曾经的面试题 （淘宝）
 * 实现一个容器，提供两个方法，add size
 * 写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 * <p>
 * 分心下面这个程序，能完成这个功能吗
 *
 * 1） List没有volatile 则无法实现
 * 2） 给list加了volatile之后，t2能够接到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，怎么做？
 */
public class MyContainer1 {
    //添加volatile 使t2能够得到通知
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        MyContainer1 c = new MyContainer1();

        new Thread(()->{
            for(int i=0; i<10; i++) {
                c.add(new Object());
                System.out.println("add " + i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            while (true) {
                if (c.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 结束");
        },"t2").start();

    }
}












