/*
package com.test2.test1.test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

*/
/**
 * 事件处理机制
 * Created by thinkpad on 2018/1/18.
 *//*



public class Demo9_3 extends JFrame implements ActionListener{

    JPanel myPanel=null;
    JButton jButton1=null;
    JButton jButton2=null;

    public static void main(String [] args){

    }

    public Demo9_3()
    {
        myPanel=new JPanel();
        jButton1=new JButton("黑色");
        jButton2=new JButton("红色");

        this.add(jButton1, BorderLayout.NORTH);
        myPanel.setBackground(Color.BLACK);
        this.add(jButton2, BorderLayout.SOUTH);
        this.add(myPanel, BorderLayout.CENTER);

        jButton1.addActionListener(this);
        jButton1.setActionCommand("aa");
        jButton2.addActionListener(this);
        jButton2.setActionCommand("bb");

        this.setSize(200,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //对事件处理的方法
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("aa")){

        }else if(e.getActionCommand().equals("bb")){

        }else{

        }
    }
}

class Cat implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

class MyPanel extends JPanel
{
    public void Paint(Graphics g)
    {
        super.paint(g);

    }
}
*/
