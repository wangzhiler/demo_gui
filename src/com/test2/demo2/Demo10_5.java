package com.test2.demo2;

/**
 * Created by thinkpad on 2018/1/21.
 */
public class Demo10_5 {

    public static void main(String []args){
        //定义三个售票窗口
        TicketWindow tw1=new TicketWindow();

        Thread t1=new Thread(tw1);
        Thread t2=new Thread(tw1);
        Thread t3=new Thread(tw1);

        t1.start();
        t2.start();
        t3.start();

    }
}

//售票窗口类
class TicketWindow implements Runnable{

    //一共2000张票
    private int nums=2000;


    @Override
    public void run() {
        while(true){
            //出票速度1s一张
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //同步代码块
            synchronized (this){
                //先判断是否还有票
                if(nums>0){
                    //显示售票信息
                    System.out.println(Thread.currentThread().getName()+"正在售出第"+nums+"票");
                    nums--;
                }else {
                    break;
                }
            }
        }
    }
}
