package com.test2.demos.demos;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Math.pow;

/**
 * Created by thinkpad on 2018/1/24.
 */
public class Interest {
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入借款年，月，日数据");
        System.out.print("输入年份");
        short yearOne=scanner.nextShort();
        System.out.print("输入月份");
        byte monthOne=scanner.nextByte();
        System.out.print("输入日期");
        byte dayOne=scanner.nextByte();
        System.out.println("输入还款年，月，日数据");
        System.out.print("输入年份");
        short yearTwo=scanner.nextShort();
        System.out.print("输入月份");
        byte monthTwo=scanner.nextByte();
        System.out.print("输入日期");
        byte dayTwo=scanner.nextByte();
        System.out.print("输入金额");
        int money=scanner.nextInt();
        System.out.print("输入日利率");
        float interest=scanner.nextFloat();


        Calendar calendar=Calendar.getInstance();
        calendar.set(yearOne,monthOne,dayOne);
        long timeOne=calendar.getTimeInMillis();
        calendar.set(yearTwo,monthTwo-1,dayTwo);
        long timeTwo=calendar.getTimeInMillis();

        Date date1=new Date(timeOne);
        Date date2=new Date(timeTwo);
        long days=(timeOne-timeTwo)/(1000*60*60*24);

        double all=money*pow((1+interest),days);

        System.out.println(all);




    }
}
