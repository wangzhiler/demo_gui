package com.test2.demos.demo7.test1_multiple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by thinkpad on 2018/1/29.
 */
public class ComputerFrame extends JFrame{
    JMenuBar menuBar;
    JMenu choiceGrade;  //选择级别的菜单
    JMenuItem grade1, grade2;
    JTextField textOne, textTwo, textResult;
    JButton getProblem, giveAnswer;
    JLabel operatorLabel, message;
    Teacher teacherZhang;

    ComputerFrame(){
        teacherZhang=new Teacher();
        teacherZhang.setMaxInteger(20);
        setLayout(new FlowLayout());
        menuBar=new JMenuBar();
        choiceGrade=new JMenu("选择级别");
        grade1=new JMenuItem("幼儿级别");
        grade2=new JMenuItem("而同级别");
        grade1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherZhang.setMaxInteger(10);
            }
        });
        grade2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                teacherZhang.setMaxInteger(50);
            }
        });

        choiceGrade.add(grade1);
        choiceGrade.add(grade2);
        menuBar.add(choiceGrade);
        setJMenuBar(menuBar);

        //1. 创建textOne,其课件字符长是5
        textOne=new JTextField(5);
        textTwo=new JTextField(5);
        textResult=new JTextField(5);
        operatorLabel=new JLabel("+");
        operatorLabel.setFont(new Font("Arial",Font.BOLD,20));
        message=new JLabel("你还没有回答呢");
        getProblem=new JButton("获取题目");
        giveAnswer=new JButton("确认答案");
        add(getProblem);
        add(textOne);
        add(operatorLabel);
        add(textTwo);
        add(new JLabel("="));
        add(textResult);
        add(giveAnswer);
        add(message);
        textResult.requestFocus();
        textOne.setEditable(false);
        textTwo.setEditable(false);
        getProblem.setActionCommand("getProblem");
        textResult.setActionCommand("answer");
        giveAnswer.setActionCommand("answer");
        teacherZhang.setJTextField(textOne,textTwo,textResult);
        teacherZhang.setJLabel(operatorLabel,message);
        //2. 将teacherZhang注册为getProblem的ActionEvent时间监视器
        getProblem.addActionListener(teacherZhang);
        //3. 将teacherZhang注册为giveAnswer的ActionEvent时间监视器
        giveAnswer.addActionListener(teacherZhang);
        //4. 将teacherZhang注册为textResult的ActionEvent时间监视器
        textResult.addActionListener(teacherZhang);
        setVisible(true);
        validate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
















