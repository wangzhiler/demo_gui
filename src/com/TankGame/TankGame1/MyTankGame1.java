package com.TankGame.TankGame1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 *  Function:TankGame1.0
 *  1. 画出坦克
 *  2. 我的坦克可以上下左右移动
 *
 */

public class MyTankGame1 extends JFrame{
    MyPanel myPanel=null;
    public static void main(String [] args)
    {
        MyTankGame1 myTankGame1=new MyTankGame1();
    }


    public MyTankGame1()
    {
        myPanel=new MyPanel();

        //启动mypanel线程
        Thread t=new Thread(myPanel);
        t.start();

        this.add(myPanel);
        this.addKeyListener(myPanel);

        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable
{
    //定义一个我的坦克
    Hero hero=null;

    //定义敌人的坦克组
    Vector<EnemyTank> enemyTanks=new Vector<EnemyTank>();
    int enemyTankSize=3;

    //构造函数
    public MyPanel()
    {
        hero=new Hero(10,10);

        //初始化敌人的坦克
        for(int i=0; i<enemyTankSize; i++){
            //创建一辆
            EnemyTank enemyTank=new EnemyTank((i+1)*50,0);
            enemyTank.setColor(1);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
        }
    }

    //重新paint
    public void paint(Graphics g)
    {
        super.paint(g);

        g.fillRect(0,0,400,300);

        //画出自己的坦克
        this.drawTank(hero.getX(), hero.getY(), g, this.hero.getDirect(), 0);

        //画出子弹
        if (hero.s!=null && hero.s.isLive==true){
            g.draw3DRect(hero.s.x,hero.s.y,2,2,false);
        }

        //画出敌人的坦克
        for(int i=0; i<enemyTanks.size(); i++){

            this.drawTank(enemyTanks.get(i).getX(), enemyTanks.get(i).getY()
                    ,g,enemyTanks.get(i).getDirect(),1);
        }
    }
    
    //画出坦克的函数
    public void drawTank(int x,int y, Graphics g, int direct, int type)
    {
        //判断是什么类型的坦克
        switch (type)
        {
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        
        //判断方向
        switch (direct)
        {
            case 0:  //向上
                //1. 画出左边的矩形
                g.fill3DRect(x,y,5,30,false);
                //2. 画出右边的矩形
                g.fill3DRect(x+15,y,5,30,false);
                //3. 画出中间的矩形
                g.fill3DRect(x+5,y+5,10,20,false);
                //4. 画出圆形
                g.fillOval(x+4,y+10,10,10);
                //5. 画出线
                g.drawLine(x+10,y+15,x+10, y);
                break;
            case 1:  //右
                g.fill3DRect(x-5,y+5,30,5,false);
                g.fill3DRect(x-5,y+20,30,5,false);
                g.fill3DRect(x,y+10,20,10,false);
                g.fillOval(x+5,y+9,10,10);
                g.drawLine(x+10,y+15,x+25,y+15);
                break;
            case 2:  //下
                g.fill3DRect(x,y,5,30,false);
                g.fill3DRect(x+15,y,5,30,false);
                g.fill3DRect(x+5,y+5,10,20,false);
                g.fillOval(x+4,y+10,10,10);
                g.drawLine(x+10,y+15,x+10, y+30);
                break;
            case 3:  //左
                g.fill3DRect(x-5,y+5,30,5,false);
                g.fill3DRect(x-5,y+20,30,5,false);
                g.fill3DRect(x,y+10,20,10,false);
                g.fillOval(x+5,y+9,10,10);
                g.drawLine(x+10,y+15,x-5,y+15);
                break;
        }

    }

    //KeyListener 对键按下进行处理
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP)
        {
            //设置我的坦克方向向上
            this.hero.setDirect(0);
            this.hero.moveUp();
        }else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            //设置我的坦克方向向右
            this.hero.setDirect(1);
            this.hero.moveRight();
        }else if(e.getKeyCode()==KeyEvent.VK_DOWN)
        {
            //设置我的坦克方向向下
            this.hero.setDirect(2);
            this.hero.moveDown();
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            //设置我的坦克方向向左
            this.hero.setDirect(3);
            this.hero.moveLeft();
        }

        //判断玩家是否发射
        if(e.getKeyCode()==KeyEvent.VK_SHIFT)
        {
            this.hero.shotEnemy();
        }

        //必须重新绘制Panel
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        //每隔100ms重画
        while (true)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}












