package com.test2.demos.demo7.test2;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by thinkpad on 2018/1/30.
 */
public class CalendarFrame extends JFrame implements ActionListener {

    JLabel labelDay[]=new JLabel[42];
    JButton titleName[]=new JButton[7];
    String name[]={"日","一","二","三","四","五","六"};
    JButton nextMonth, previousMonth;
    CalendarBean calendar;
    JLabel showMessage=new JLabel("",JLabel.CENTER);
    int year=2011, month=2;

    JTextField field = new JTextField(10);

    public CalendarFrame(){
        JPanel pCenter=new JPanel();
        //1. 将pCenter的布局设置为7行7列的GridLayout布局
        pCenter.setLayout(new GridLayout(7,7));
        for(int i=0; i<7; i++){
            titleName[i]=new JButton(name[i]);
            titleName[i].setBorder(new SoftBevelBorder(BevelBorder.RAISED));
            pCenter.add(titleName[i]);
        }
        for(int i=0; i<42; i++){
            labelDay[i]=new JLabel("", JLabel.CENTER);
            labelDay[i].setBorder(new SoftBevelBorder(BevelBorder.LOWERED));
            //2. pCenter添加组件labelDay[i]
            pCenter.add(labelDay[i]);
        }
        calendar=new CalendarBean();
        nextMonth=new JButton("下月");
        previousMonth=new JButton("上月");



        nextMonth.addActionListener(this);
        previousMonth.addActionListener(this);
        JPanel pNorth=new JPanel(), pSouth=new JPanel();

        field.addActionListener(this);
        pNorth.add(field);


        pNorth.add(previousMonth);
        pNorth.add(nextMonth);
        pSouth.add(showMessage);



        add(pCenter, BorderLayout.CENTER);
        //3. 窗口添加pNorth在北面区域
        add(pNorth, BorderLayout.NORTH);
        //4. 窗口添加pSouth在南面区域
        add(pSouth, BorderLayout.SOUTH);
        setYearAndMonth(year,month);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void setYearAndMonth(int year, int month) {
        calendar.setYear(year);
        calendar.setMonth(month);
        String day[]=calendar.getCalendar();
        for(int i=0; i<42; i++)
            labelDay[i].setText(day[i]);
        showMessage.setText("日历：" + calendar.getYear() + "年" + calendar.getMonth() + "月");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==nextMonth){
            month=month+1;
            if(month>12)
                month=1;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            for(int i=0; i<42; i++){
                labelDay[i].setText(day[i]);
            }
        }
        else if(e.getSource()==previousMonth){
            month=month-1;
            if(month<1)
                month=12;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            for(int i=0; i<42; i++)
                labelDay[i].setText(day[i]);
        }
        else if(e.getSource()==field){
            String s_year=field.getText();
            int i_year = Integer.parseInt(s_year);
            calendar.setYear(i_year);
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();
            for(int i=0; i<42; i++)

                labelDay[i].setText(day[i]);
        }
        showMessage.setText("日历：" + calendar.getYear() + "年" + calendar.getMonth() + "月");
    }
}













