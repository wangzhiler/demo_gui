package com.test2.demos.demo7.test3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by thinkpad on 2018/1/31.
 */
public class SpellingWordFrame extends JFrame implements KeyListener, ActionListener
{
    static int count=0;

    JTextField inputWord;
    JButton button;
    LetterLabel label[];
    JPanel northP, centerP;
    Box wordBox;
    String hintMessage="用鼠标单击字母，按左右箭头交换字母，将其排列成所输入的单词";
    JLabel messageLabel=new JLabel(hintMessage);
    String word = "";
    SpellingWordFrame(){
        inputWord=new JTextField(12);
        button=new JButton("确定");
        button.addActionListener(this);
        inputWord.addActionListener(this);
        northP = new JPanel();
        northP.add(new JLabel("输入单词："));
        northP.add(inputWord);
        northP.add(button);
        centerP = new JPanel();
        wordBox = Box.createHorizontalBox();
        centerP.add(wordBox);
        add(northP, BorderLayout.NORTH);
        add(centerP, BorderLayout.CENTER);
        add(messageLabel, BorderLayout.SOUTH);
        setBounds(100, 100, 350, 180);
        setVisible(true);
        validate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        word=inputWord.getText();
        int n=word.length();
        RondomString RondomString=new RondomString();
        String randomWord=RondomString.getRondomString(word);
        wordBox.removeAll();
        messageLabel.setText(hintMessage);
        if(n>0){
            label = LetterLabel.getLetterLabel(n);
            for(int k=0; k<label.length; k++){
                label[k].setText(""+randomWord.charAt(k));
                wordBox.add(label[k]);
                //2. 将当前窗口注册为label[k]的键盘监视器
                label[k].addKeyListener(this);
            }
            validate();
            inputWord.setText(null);
            label[0].requestFocus();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        LetterLabel sourceLabel=(LetterLabel)e.getSource();
        count++;
        int index=-1;
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            for(int k=0; k<label.length; k++){
                if(label[k]==sourceLabel){
                    index=k;
                    break;
                }
            }

            if(index!=0){  //交换文本框中的字母
                String temp=label[index].getText();
                label[index].setText(label[index-1].getText());
                label[index-1].setText(temp);
                label[index-1].requestFocus();
            }
        }
        //3. 判断按下的是否是“→”键
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            for(int k=0; k<label.length; k++){
                if(label[k]==sourceLabel){
                    index=k;
                    break;
                }
            }
            if(index!=label.length-1){
                String temp=label[index].getText();
                label[index].setText(label[index+1].getText());
                label[index+1].setText(temp);
                label[index+1].requestFocus();
            }
        }
        validate();
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        String success="";
        for(int k=0; k<label.length; k++){
            String str=label[k].getText();
            success=success+str;
        }
        if(success.equals(word)){
            messageLabel.setText("恭喜你，你成功了，且你一共移动了"+count+"次");
            count=0;
            for(int k=0; k<label.length; k++){
                label[k].removeKeyListener(this);
                label[k].removeFocusListener(label[k]);
                label[k].setBackground(Color.WHITE);
            }
            inputWord.requestFocus();
        }
    }



}
