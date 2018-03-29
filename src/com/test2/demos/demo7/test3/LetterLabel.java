package com.test2.demos.demo7.test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by thinkpad on 2018/1/31.
 */
public class LetterLabel extends JTextField implements FocusListener {
    LetterLabel(){
        setEditable(false);
        //1. 将当前对象注册为自身的焦点视器
        this.addFocusListener(this);
        setBackground(Color.WHITE);
        setFont(new Font("Arial",Font.PLAIN,30));
    }
    public static LetterLabel[] getLetterLabel(int n){
        LetterLabel a[]=new LetterLabel[n];
        for(int k=0; k<a.length; k++)
            a[k]=new LetterLabel();
        return a;
    }


    @Override
    public void focusGained(FocusEvent e) {
        setBackground(Color.cyan);
    }

    @Override
    public void focusLost(FocusEvent e) {
        setBackground(Color.WHITE);
    }

    public void setText(char c){
        setText(""+c);
    }
}
