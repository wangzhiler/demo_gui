package com.high_concurrency.hc_005_ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by thinkpad on 2018/4/7.
 *
 * ThreadLocal线程局部变量
 *
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 * 比如在hibernate中session就存在ThreadLocal中，避免synchronized的使用
 *
 * 运行下面的程序，解释ThreadLocal
 *
 * 输出：null
 *
 */
public class ThreadLocal2 {

//    volatile static Person p=new Person();

    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());

        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());

        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }
}

