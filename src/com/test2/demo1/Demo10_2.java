package com.test2.demo1;

/**
 * Created by thinkpad on 2018/1/21.
 */
public class Demo10_2 {

    public static void main(String [] args)
    {
        //注意启动
        Dog dog=new Dog();
        //创建一个Thread对象
        Thread t=new Thread(dog);
        t.start();
    }
}

class Dog implements Runnable
{

    int times=0;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            times++;
            System.out.println("hello"+times);
            if(times==3){
                break;
            }
        }
    }
}
