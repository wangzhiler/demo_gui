package com.test2.demos.demos;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by thinkpad on 2018/1/24.
 */
public class CompareTime {
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入第一个年，月，日数据");
        System.out.print("输入年份");
        short yearOne=scanner.nextShort();
        System.out.print("输入月份");
        byte monthOne=scanner.nextByte();
        System.out.print("输入日期");
        byte dayOne=scanner.nextByte();
        System.out.print("输入时");
        byte hourOne=scanner.nextByte();
        System.out.print("输入分");
        byte minuteOne=scanner.nextByte();
        System.out.print("输入秒");
        byte secondOne=scanner.nextByte();


        System.out.println("输入第二个年，月，日数据");
        System.out.print("输入年份");
        short yearTwo=scanner.nextShort();
        System.out.print("输入月份");
        byte monthTwo=scanner.nextByte();
        System.out.print("输入日期");
        byte dayTwo=scanner.nextByte();
        System.out.print("输入时");
        byte hourTwo=scanner.nextByte();
        System.out.print("输入分");
        byte minuteTwo=scanner.nextByte();
        System.out.print("输入秒");
        byte secondTwo=scanner.nextByte();

        Calendar calendar=Calendar.getInstance();
        calendar.set(yearOne,monthOne,dayOne,hourOne,minuteOne,secondOne);
        long timeOne=calendar.getTimeInMillis();
        calendar.set(yearTwo,monthTwo,dayTwo,hourTwo,minuteTwo,secondTwo);
        long timeTwo=calendar.getTimeInMillis();
        Date date1=new Date(timeOne);
        Date date2=new Date(timeTwo);
        if(date2.equals(date1))
            System.out.println("两个日期的年、月、日完全相同");
        else if(date2.after(date1))
            System.out.println("您输入的第二个日期大于第一个日期");
        else if(date2.before(date1))
            System.out.println("您输入的第二个日期小于第一个日期");
        long seconds=(timeOne-timeTwo)/(1000);
        System.out.println("相隔"+seconds+"秒");




    }
}
