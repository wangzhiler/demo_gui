package com.test2.demo1;

/**
 * Created by thinkpad on 2018/1/21.
 */
public class Demo10_3 {

    public static void main(String [] args)
    {
        Pig pig=new Pig(10);
        Bird bird=new Bird(10);
        Thread t1=new Thread(pig);
        Thread t2=new Thread(bird);
        t1.start();
        t2.start();
    }
}

//打印
class Pig implements Runnable
{
    int n=0;
    int times=0;

    public Pig(int n){
        this.n=n;
    }
    @Override
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            times++;
            System.out.println("我是一个线程"+times);
            if(times==n)
                break;
        }
    }
}


//算数学题
class Bird implements Runnable
{
    int n=0;
    int res=0;
    int times=0;

    public Bird(int n){
        this.n=n;
    }

    @Override
    public void run() {

        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            res+=(++times);
            System.out.println("   "+res);

            if(times==n){
                System.out.println("最后结果是"+res);
                break;
            }
        }
    }
}
