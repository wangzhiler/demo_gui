package com.test2.demos.demos;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by thinkpad on 2018/1/24.
 */
public class CompareDate {
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入第一个年，月，日数据");
        System.out.print("输入年份");
        short yearOne=scanner.nextShort();
        System.out.print("输入月份");
        byte monthOne=scanner.nextByte();
        System.out.print("输入日期");
        byte dayOne=scanner.nextByte();
        System.out.println("输入第二个年，月，日数据");
        System.out.print("输入年份");

        short yearTwo=scanner.nextShort();
        System.out.print("输入月份");
        byte monthTwo=scanner.nextByte();
        System.out.print("输入日期");
        byte dayTwo=scanner.nextByte();
        //1. 初始化日历对象
        Calendar calendar=Calendar.getInstance();
        //2. 将calendar的时间设置为yearOne年monthOne月dayOne日
        calendar.set(yearOne,monthOne,dayOne);
        //3. calendar表示的时间转换成毫秒
        long timeOne=calendar.getTimeInMillis();
        calendar.set(yearTwo,monthTwo-1,dayTwo);
        long timeTwo=calendar.getTimeInMillis();
        //4. 用TimeOne做参数构造date1
        Date date1=new Date(timeOne);
        Date date2=new Date(timeTwo);
        if(date2.equals(date1))
            System.out.println("两个日期的年、月、日完全相同");
        else if(date2.after(date1))
            System.out.println("您输入的第二个日期大于第一个日期");
        else if(date2.before(date1))
            System.out.println("您输入的第二个日期小于第一个日期");
        //5. 使用timeTwo,timeOne计算两个日期相隔天数
        long days=(timeOne-timeTwo)/(1000*60*60*24);
        System.out.println(yearOne+"年"+monthOne+"月"+dayOne+"日和"
                +yearTwo+"年"+monthTwo+"月"+dayTwo+"相隔"+days+"天");




    }
}
