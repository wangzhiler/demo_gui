/*


package com.test2.test1.test1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

*/
/**
 * 通过上下左右控制一个小球
 *
 * Created by thinkpad on 2018/1/18.
 *//*

public class Demo9_4 extends JFrame{

    MyPanel myPanel=null;

    public static void main(String [] args)
    {
        Demo9_4 demo9_4=new Demo9_4();
    }

    public Demo9_4()
    {
        myPanel=new MyPanel();

        //mypanel加入到JFrame


        this.add(myPanel);

        this.addKeyListener(myPanel);

        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//自定义自己的panel
class MyPanel extends JPanel implements KeyListener
{
    int x=10;
    int y=10;
    public void paint(Graphics g)
    {
        super.paint(g);

        g.fillOval(x,y,20,20);
    }

    //键的一个值被输出
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //键被按下
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            y++;
        }else if(e.getKeyCode()==KeyEvent.VK_UP){
            y--;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            x--;
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            x++;
        }
        //调用repaint函数
        this.repaint();
    }

    //键被释放
    @Override
    public void keyReleased(KeyEvent e) {

    }
}*/
