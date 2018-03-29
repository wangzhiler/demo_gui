package com.test2.demos.demo7.test1_multiple;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by thinkpad on 2018/1/29.
 */
public class Teacher implements ActionListener {

    int numberOne, numberTwo;
    String operator="";
    boolean isRight;
    Random random;  //用于给出随机数
    int maxInteger;  //题目中最大的整数
    JTextField textOne, textTwo, textResult;
    JLabel operatorLabel, message;

    Teacher(){
        random=new Random();
    }
    public void setMaxInteger(int n){
        maxInteger=n;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        if(str.equals("getProblem")){
            numberOne=random.nextInt(maxInteger)+1;
            //1至maxIntegrer之间的随机数
            numberTwo=random.nextInt(maxInteger)+1;
            double d=Math.random();     //获取(0,1)之间的随机数
            if(d>=0.7){
                operator="+";
            }else if(d>0.3 && d<0.7){
                operator="-";
            }else{
                operator = "*";
            }
            textOne.setText(""+numberOne);
            textTwo.setText(""+numberTwo);
            operatorLabel.setText(operator);
            message.setText("请回答");
            textResult.setText(null);
        }
        else if(str.equals("answer")){
            String answer=textResult.getText();
            try{
                int result=Integer.parseInt(answer);
                if(operator.equals("+")) {
                    if (result == numberOne + numberTwo)
                        message.setText("你回答正确");
                    else
                        message.setText("你回答错误");
                }
                else if(operator.equals("-")){
                    if(result==numberOne-numberTwo)
                        message.setText("你回答正确");
                    else
                        message.setText("你回答错误");
                } else if (operator.equals("*")) {
                    if(result==numberOne * numberTwo)
                        message.setText("你回答正确");
                    else
                        message.setText("你回答错误");
                }
            }catch (NumberFormatException ex){
                message.setText("请输入数字字符");
            }
        }
    }

    public void setJTextField(JTextField ... t){
        textOne=t[0];
        textTwo=t[1];
        textResult=t[2];
    }
    public void setJLabel(JLabel ...label){
        operatorLabel=label[0];
        message=label[1];
    }
}























