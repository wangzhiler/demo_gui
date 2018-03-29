package com.test2.test1.test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by thinkpad on 2018/1/20.
 */
public class Demo9_5 extends JFrame{


    MyPanel myPanel=null;
    public static void main(String [] args)
    {
        Demo9_5 demo9_5=new Demo9_5();
    }

    public void Demo9_5()
    {
        myPanel=new MyPanel();

        this.add(myPanel);

        //注册监听
        this.addMouseListener(myPanel);
        this.addKeyListener(myPanel);
        this.addMouseMotionListener(myPanel);
        this.addWindowListener(myPanel);

        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//1. 让MyPanel知道鼠标按下的消息，并且知道点击的位置(x,y)
//2. 让MyPanel知道哪个键按下了
//3. 让MyPanel知道鼠标移动，拖拽
//4. 让MyPanel知道窗口的变化（关闭，最小化，最大化）

class MyPanel extends JPanel implements MouseListener, KeyListener
    ,MouseMotionListener,WindowListener
{
    public void paint(Graphics g)
    {
        super.paint(g);
    }


    //1. 鼠标点击
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {

    }

    //鼠标按下
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {

    }

    //鼠标松开
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    // 鼠标移动到MyPanel
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {

    }


    //鼠标离开MyPanel
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }


    //键盘输入
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //键按下
    @Override
    public void keyPressed(KeyEvent e) {

    }

    //键松开
    @Override
    public void keyReleased(KeyEvent e) {

    }


    //鼠标拖拽
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

    }

    //鼠标移动
    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {

    }




    //窗口打开了
    @Override
    public void windowOpened(WindowEvent e) {

    }

    //窗口正在关闭
    @Override
    public void windowClosing(WindowEvent e) {

    }

    //
    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    //窗口最小化
    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
