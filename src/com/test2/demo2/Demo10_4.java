package com.test2.demo2;

/**
 * 使用线程的注意事项
 * Created by thinkpad on 2018/1/21.
 */
public class Demo10_4 {
    public static void main(String [] args)
    {

    }
}

class Cat extends Thread
{
    public void run()
    {
        System.out.println("11");
    }
}

class Dog implements Runnable
{

    @Override
    public void run() {
        System.out.println("12");
    }
}
