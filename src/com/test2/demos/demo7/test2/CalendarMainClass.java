package com.test2.demos.demo7.test2;

/**
 * Created by thinkpad on 2018/1/30.
 */
public class CalendarMainClass {
    public static void main(String []args){
        CalendarFrame frame = new CalendarFrame();
        frame.setBounds(100, 100, 360, 300);
        frame.setVisible(true);
        frame.setYearAndMonth(2015,5);
    }
}
