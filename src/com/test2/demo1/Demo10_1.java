package com.test2.demo1;

/**
 * 通过继承Thread来开发线程
 * Created by thinkpad on 2018/1/21.
 */
public class Demo10_1 {

    public static void main(String [] args)
    {
        //创建一个cat对象
        Cat cat=new Cat();
        //启动线程，会导致run函数的运行
        cat.start();
    }
}

class Cat extends Thread{

    int times=0;

    //重写run函数
    public void run(){
        while(true){
            //休眠一秒,1000毫秒  sleep会让该线程进入阻塞状态
            //Blocked状态，会释放资源
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            times++;
            System.out.println("hello, world");
            if(times==3){
                break;
            }
        }
    }
}
