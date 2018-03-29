package com.TankGame.TankGame2;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Function:TankGame1.0
 * 1. 画出坦克
 * 2. 我的坦克可以上下左右移动
 * 3. 子弹可以连发,最多五颗
 * 4. 当我的坦克击中敌人坦克时，敌人就消失（爆炸的效果）
 * 5. 我被击中后，显示爆炸效果
 * 6. 放置敌人敌人坦克重叠运动
 *  6.1 把判断是否碰撞的函数写到EnemyTank类
 * 7. 可以分关
 *  7.1 做一个开始的Panel，它是一个空的
 *  7.2 字体闪烁
 * 8. 可以在玩游戏的时候暂停和继续
 *  8.1 当用户点击暂停时，子弹速度和坦克速度=0，并让坦克的方向不动
 * 9. 可以记录玩家的成绩
 *  9.1 用文件流
 *  9.2 单写一个记录类，完成对玩家记录
 *  9.3 先完成保存共击毁了多少辆敌人坦克的功能
 *  9.4 存盘退出游戏，可以记录当时的敌人坦克坐标，并可以恢复
 *
 *
 *
 */



public class MyTankGame2 extends JFrame implements ActionListener{

    MyPanel myPanel = null;

    //定义一个开始面板
    MyStartPanel myStartPanel=null;

    //菜单
    JMenuBar jMenuBar=null;
    //开始游戏
    JMenu jMenu1=null;
    JMenuItem jMenuItem1=null;
    //退出系统
    JMenuItem jMenuItem2=null;
    //存盘退出游戏
    JMenuItem jMenuItem3=null;
    //继续上局
    JMenuItem jMenuItem4=null;

    public static void main(String[] args) {
        MyTankGame2 myTankGame1 = new MyTankGame2();
    }


    public MyTankGame2() {
        //创建菜单及菜单选项
        jMenuBar=new JMenuBar();
        jMenu1 = new JMenu("游戏(G)");
        jMenu1.setMnemonic('G');
        jMenuItem1 = new JMenuItem("开始新游戏(N)");
        jMenuItem1.setMnemonic('N');
        //对jmenuItem1
        jMenuItem1.addActionListener(this);
        jMenuItem1.setActionCommand("NewGame");

        jMenuItem2 = new JMenuItem("退出游戏(E)");
        jMenuItem2.setMnemonic('E');
        jMenuItem2.addActionListener(this);
        jMenuItem2.setActionCommand("Exit");

        jMenuItem3 = new JMenuItem("存盘退出游戏(S)");
        jMenuItem3.setMnemonic('S');
        jMenuItem3.addActionListener(this);
        jMenuItem3.setActionCommand("Save&Exit");


        jMenuItem4 = new JMenuItem("继续上局(C)");
        jMenuItem4.setMnemonic('C');
        jMenuItem4.addActionListener(this);
        jMenuItem4.setActionCommand("Continue");

        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem3);
        jMenu1.add(jMenuItem4);
        jMenuBar.add(jMenu1);

        myStartPanel=new MyStartPanel();
        Thread t = new Thread(myStartPanel);
        t.start();
        this.add(myStartPanel);

        this.setJMenuBar(jMenuBar);
        this.setSize(600, 500);
        this.setLocation(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NewGame")){
            myPanel = new MyPanel("NewGame");
            //启动mypanel线程
            Thread t1 = new Thread(myPanel);
            t1.start();
            //先删除旧的面板
            this.remove(myStartPanel);
            this.add(myPanel);
            this.addKeyListener(myPanel);
            //显示，刷新JFrame
            this.setVisible(true);
        } else if (e.getActionCommand().equals("Exit")) {
            //用户点击了退出系统的菜单
            //保存击毁敌人数量
            Recorder.keepRecorder();

            System.exit(0);
        } else if (e.getActionCommand().equals("Save&Exit")) {
            //工作
            //保存击毁敌人的数量和敌人的坐标
            Recorder.setEnemyTanks(myPanel.enemyTanks);
            Recorder.keepRecAndEnemyTank();

            //退出
            System.exit(0);
        } else if (e.getActionCommand().equals("Continue")) {
            myPanel = new MyPanel("Continue");

            //启动mypanel线程
            Thread t1 = new Thread(myPanel);
            t1.start();
            //先删除旧的面板
            this.remove(myStartPanel);
            this.add(myPanel);
            this.addKeyListener(myPanel);
            //显示，刷新JFrame
            this.setVisible(true);
        }
    }
}

//就是一个提示作用
class MyStartPanel extends JPanel implements Runnable{
    int times=0;

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,400,300);
        //提示信息

        if (times % 2 == 0) {
            g.setColor(Color.yellow);
            //开关信息的字体
            Font myFont = new Font("华文新魏", Font.BOLD, 30);
            g.setFont(myFont);
            g.drawString("stage: 1",125,150);
            if (times == 10) {
                times=0;
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            //休眠
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                e.printStackTrace();
            }
            times++;
            //重画
            this.repaint();
        }
    }
}

//我的面板
class MyPanel extends JPanel implements KeyListener,Runnable
{
    //定义一个我的坦克
    Hero hero=null;

    //判断是续上局还是新游戏
    String flag="NewGame";

    //定义敌人的坦克组
    Vector<EnemyTank> enemyTanks=new Vector<EnemyTank>();
    Vector<Node> nodes=new Vector<Node>();

    //定义炸弹集合
    Vector<Bomb> bombs=new Vector<Bomb>();

    int enemyTankSize=3;

    //定义三张图片
    Image image1=null;
    Image image2=null;
    Image image3=null;

    //构造函数
    public MyPanel(String flag)
    {
        //恢复记录
        Recorder.getRecording();
        this.flag=flag;

        hero=new Hero(100,100);

        if (this.flag.equals("NewGame")) {
            //初始化敌人的坦克
            for(int i=0; i<enemyTankSize; i++){
                //创建一辆
                EnemyTank enemyTank=new EnemyTank((i+1)*50,0);
                enemyTank.setColor(1);
                enemyTank.setDirect(2);
                //将MyPanel的敌人坦克向量交给该敌人坦克
                enemyTank.setEnemyTanks(enemyTanks);

                //启动敌人的坦克
                Thread t=new Thread(enemyTank);
                t.start();
                //给敌人坦克添加一颗子弹
                Shot s=new Shot(enemyTank.x+10, enemyTank.y+30, 2);
                enemyTank.ss.add(s);
                Thread t2=new Thread(s);
                t2.start();
                //加入
                enemyTanks.add(enemyTank);
            }
        }else{
            nodes=new Recorder().getNodesAndKilledEnNums();
            //初始化敌人的坦克
            for(int i=0; i<nodes.size(); i++){
                Node node = nodes.get(i);
                //创建一辆
                EnemyTank enemyTank=new EnemyTank(node.x,node.y);
                enemyTank.setColor(1);
                enemyTank.setDirect(node.direct);
                //将MyPanel的敌人坦克向量交给该敌人坦克
                enemyTank.setEnemyTanks(enemyTanks);

                //启动敌人的坦克
                Thread t=new Thread(enemyTank);
                t.start();
                //给敌人坦克添加一颗子弹
                Shot s=new Shot(enemyTank.x+10, enemyTank.y+30, 2);
                enemyTank.ss.add(s);
                Thread t2=new Thread(s);
                t2.start();
                //加入
                enemyTanks.add(enemyTank);
            }
        }



        try {
            image1= ImageIO.read(new File("src\\bomb_1.gif"));
            image2= ImageIO.read(new File("src\\bomb_2.gif"));
            image3= ImageIO.read(new File("src\\bomb_3.gif"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Bomb b=new Bomb(0,0);
        bombs.add(b);
    }

    //重新paint
    public void paint(Graphics g)
    {
        super.paint(g);

        g.fillRect(0,0,400,300);

        this.showInfo(g);

        //画出自己的坦克
        if(hero.isLive){
            this.drawTank(hero.getX(), hero.getY(), g, this.hero.getDirect(), 0);
        }

        //从ss取出每一颗子弹，并画出
        for(int i=0; i<this.hero.ss.size(); i++){

            Shot myShot=hero.ss.get(i);

            //画出一颗子弹
            if (myShot!=null && myShot.isLive==true){
                g.draw3DRect(myShot.x,myShot.y,2,2,false);
            }
            if(myShot.isLive==false){
                hero.ss.remove(myShot);
            }
        }

        //画出炸弹
        for(int i=0; i<bombs.size(); i++){
            //取出炸弹
            Bomb b=bombs.get(i);
            if(b.life>6){
                g.drawImage(image1, b.x,b.y,30,30,this);
            }else if(b.life>3){
                g.drawImage(image2, b.x,b.y,30,30,this);
            }else if(b.life>0){
                g.drawImage(image3, b.x,b.y,30,30,this);
            }
            //让b的生命值减少
            b.lifeDown();
            //如果炸弹生命值==0，remove
            if(b.life==0){
                bombs.remove(b);
            }
        }


        //画出敌人的坦克
        for(int i=0; i<enemyTanks.size(); i++){

            EnemyTank enemyTank=enemyTanks.get(i);
            if(enemyTank.isLive){
                this.drawTank(enemyTanks.get(i).getX(), enemyTanks.get(i).getY()
                        ,g,enemyTanks.get(i).getDirect(),1);

                //在画出敌人的子弹
                for(int j=0; j<enemyTank.ss.size(); j++){
                    //取出子弹
                    Shot enemyShot=enemyTank.ss.get(j);
                    if(enemyShot.isLive){
                        g.draw3DRect(enemyShot.x, enemyShot.y,1,1,false);
                    }else{
                        //如果敌人的坦克死亡就从Vector中去掉
                        enemyTank.ss.remove(j);
                    }
                }
            }
        }
    }

    //画出提示信息
    public void showInfo(Graphics g) {
        //画出提示信息坦克
        this.drawTank(80,330,g,0,1);
        g.setColor(Color.black);
        g.drawString(Recorder.getEnNum()+"", 105, 350);

        this.drawTank(140,330,g,0,0);
        g.setColor(Color.black);
        g.drawString(Recorder.getMyLife()+"",165,350);

        //画出玩家的总成绩
        g.setColor(Color.black);
        Font f = new Font("宋体", Font.BOLD, 20);
        g.setFont(f);
        g.drawString("您的总成绩",420,40);

        this.drawTank(450,60,g,0,1);

        g.setColor(Color.black);
        g.drawString(Recorder.getKilledEnNum()+"",490,80);

    }

    //我的坦克是否被敌人击中
    public void hitMe()
    {
        //取出每一个敌人的坦克
        for(int i=0; i<this.enemyTanks.size(); i++)
        {
            //取出坦克
            EnemyTank enemyTank=enemyTanks.get(i);
            //取出每一颗子弹
            for(int j=0; j<enemyTank.ss.size(); j++){
                Shot enemyShot=enemyTank.ss.get(j);
                if (hero.isLive) {
                    this.hitTank(enemyShot,hero);
                }
            }
        }
    }

    //判断我的子弹是否击中敌人坦克
    public void hitEnemyTank(){
        //判断是否击中敌人坦克
        for(int i=0; i<hero.ss.size(); i++){
            //取出子弹
            Shot myShot=hero.ss.get(i);
            //判断子弹是否有效
            if(myShot.isLive){
                //取出每个坦克，与它判断
                for(int j=0; j<enemyTanks.size(); j++){
                    //取出坦克
                    EnemyTank enemyTank=enemyTanks.get(j);
                    if(enemyTank.isLive){
                        if(this.hitTank(myShot,enemyTank)){
                            Recorder.reduceEnNum();
                            //增加我的记录
                            Recorder.addEnNum();
                        }
                    }
                }
            }
        }
    }



    //写出一个函数专门判断子弹是否击中敌人的坦克
    public boolean hitTank(Shot s, Tank Tank){
        boolean b2=false;
        //判断该坦克的方向
        switch (Tank.direct){
            //如果敌人方向是上/下
            case 0:
            case 2:
                if(s.x>=Tank.x && s.x<=Tank.x+20
                        && s.y>=Tank.y && s.y<=Tank.y+30){
                    //击中
                    //子弹死亡
                    s.isLive=false;
                    //敌人坦克死亡
                    Tank.isLive=false;
                    //创建一颗炸弹，放入Vector
                    Bomb b=new Bomb(Tank.x,Tank.y);
                    bombs.add(b);
                    b2=true;
                }
                break;
            case 1:
            case 3:
                if(s.x>=Tank.x && s.x<=Tank.x+30
                        && s.y>=Tank.y && s.y<=Tank.y+20){
                    //击中
                    s.isLive=false;
                    Tank.isLive=false;
                    Bomb b=new Bomb(Tank.x,Tank.y);
                    bombs.add(b);
                    b2=true;
                }
                break;
        }

        return b2;
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
            if(this.hero.ss.size()<=4){
                this.hero.shotEnemy();
            }
        }

        //必须重新绘制Panel
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        //每隔10ms重画
        while (true)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.hitEnemyTank();

            //函数，判断敌人的子弹是否击中我
            this.hitMe();

            this.repaint();
        }
    }

}












