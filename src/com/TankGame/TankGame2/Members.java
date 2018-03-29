package com.TankGame.TankGame2;

import java.io.*;
import java.util.Vector;

/**
 * Created by thinkpad on 2018/1/20.
 */

class Node{
    int x;
    int y;
    int direct;
    public Node(int x, int y, int direct){
        this.x=x;
        this.y=y;
        this.direct=direct;
    }
}

//记录类
class Recorder{
    //记录每关有多少敌人
    private static int enNum=3;
    //设置我有多少可以用的人
    private static int myLife=1;


    //记录总共消灭了多少敌人
    private static int KilledEnNum=0;

    //保存从文件中恢复记录点
    static Vector<Node> nodes=new Vector<Node>();

    private static FileWriter fileWriter=null;
    private static BufferedWriter bufferedWriter=null;

    private static FileReader fileReader=null;
    private static BufferedReader bufferedReader=null;

    private static Vector<EnemyTank> enemyTanks=new Vector<EnemyTank>();
    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }
    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    //完成读取任务
    public Vector<Node> getNodesAndKilledEnNums(){
        try {
            fileReader = new FileReader("src\\myRecorder.txt");
            bufferedReader = new BufferedReader(fileReader);
            String n="";
            //先读取第一行
            n= bufferedReader.readLine();
            while ((n = bufferedReader.readLine())!=null) {
                String []xyz=n.split(" ");  //50 100 2
                Node node=new Node(Integer.parseInt(xyz[0]),Integer.parseInt(xyz[1]),Integer.parseInt(xyz[2]));
                nodes.add(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return nodes;
    }

    //保存击毁敌人的数量和对人坦克方向、坐标
    public static void keepRecAndEnemyTank(){
        try {
            fileWriter = new FileWriter("src\\myRecorder.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(KilledEnNum+"\r\n");

            //保存当前活的敌人坦克的坐标和方向
            for(int i=0; i<enemyTanks.size(); i++) {
                //取出第一个坦克
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive) {
                    //活的就保存
                    String record=enemyTank.x+" "+enemyTank.y+" "+enemyTank.direct;
                    //写入
                    bufferedWriter.write(record+"\r\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //从文件中读取，记录
    public static void getRecording()
    {
        try {
            fileReader = new FileReader("src\\myRecorder.txt");
            bufferedReader = new BufferedReader(fileReader);
            String n=bufferedReader.readLine();
            KilledEnNum = Integer.parseInt(n);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //把玩家击毁坦克数量保存到文件中
    public static void keepRecorder(){
        try {
            fileWriter = new FileWriter("src\\myRecorder.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(KilledEnNum+"\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getKilledEnNum() {
        return KilledEnNum;
    }

    public static void setKilledEnNum(int killedEnNum) {
        KilledEnNum = killedEnNum;
    }
    public static  int  getEnNum() {
        return enNum;
    }public static void setEnNum(int enNum) {
        Recorder.enNum = enNum;
    }public static int  getMyLife() {
        return myLife;
    }public static void setMyLife(int myLife) {
        Recorder.myLife = myLife;
    }


    //减少敌人数
    public static void reduceEnNum(){
        enNum--;
    }

    public static void addEnNum(){
        KilledEnNum++;
    }
}

//炸弹类
class Bomb
{
    //定义炸弹坐标
    int x, y;
    //炸弹的声明
    int life=9;
    boolean isLive=true;

    public Bomb(int x, int y){
        this.x=x;
        this.y=y;
    }

    //减少生命值
    public void lifeDown()
    {
        if(life>0){
            life--;
        }else{
            this.isLive=false;
        }
    }
}

//子弹类
class Shot implements Runnable{
    int x;
    int y;
    int direct;
    int speed=1;
    //是否还活着
    boolean isLive=true;
    public Shot(int x, int y, int direct){
        this.x=x;
        this.y=y;
        this.direct=direct;
    }

    @Override
    public void run() {


        while(true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct)
            {
                case 0:
                    y-=speed;
                    break;
                case 1:
                    x+=speed;
                    break;
                case 2:
                    y+=speed;
                    break;
                case 3:
                    x-=speed;
                    break;
            }
//            System.out.println("子弹坐标"+x+"  "+y);

            //子弹何时死亡

            //判断该子弹是否碰到边缘
            if(x<0 || x>400 ||y<0||y>300){
                this.isLive=false;
                break;
            }
        }
    }
}

//坦克类
class Tank
{
    int x=0;  //坦克横坐标
    int y=0;  //坦克纵坐标

    //坦克方向，0表示上，1表示右，2表示下，3表示左
    int direct=0;
    int color;

    boolean isLive=true;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    //


    //坦克的速度
    int speed=1;

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tank(int x, int y){
        this.x=x;
        this.y=y;
    }

}

//敌人的坦克，做成线程类
class EnemyTank extends Tank implements Runnable
{

    int times=0;

    //定义一个向量，可以访问到MyPanel上所有敌人的坦克
    Vector<EnemyTank> enemyTanks=new Vector<EnemyTank>();

    //定义一个向量，可以存放敌人的子弹
    Vector<Shot> ss=new Vector<Shot>();
    //敌人添加子弹，应当在刚刚创建坦克和敌人的坦克子弹死亡后

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    //得到MyPanel的敌人坦克向量
    public void setEnemyTanks(Vector<EnemyTank> vv) {
        this.enemyTanks=vv;
    }

    //判断是否碰到了别的敌人坦克
    public boolean isTouchOtherEnemy() {
        boolean b=false;

        switch (this.direct) {
            case 0:
                //我的坦克向上，取出所有敌人坦克
                for(int i=0; i<enemyTanks.size(); i++) {
                    //取出第一个坦克
                    EnemyTank enemyTank=enemyTanks.get(i);
                    //如果不是自己
                    if (enemyTank != this) {
                        //如果敌人的方向是向下或者向上
                        if (enemyTank.direct == 0 || enemyTank.direct == 2) {
                            if (this.x >= enemyTank.x -10 && this.x <= enemyTank.x + 30
                                    && this.y >= enemyTank.y -10 && this.y <= enemyTank.y + 40) {
                                return true;
                            }
                            if (this.x + 20 >= enemyTank.x -10 && this.x + 20 <= enemyTank.x + 30
                                    && this.y >= enemyTank.y -10&& this.y <= enemyTank.y + 40) {
                                return true;
                            }
                        }
                        if (enemyTank.direct == 1 || enemyTank.direct == 3) {
                            if (this.x >= enemyTank.x -10&& this.x <= enemyTank.x + 40
                                    && this.y >= enemyTank.y-10 && this.y <= enemyTank.y + 30) {
                                return true;
                            }
                            if (this.x + 20 >= enemyTank.x -10&& this.x + 20 <= enemyTank.x + 40
                                    && this.y >= enemyTank.y-10 && this.y <= enemyTank.y + 30) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                //我的坦克向右，取出所有敌人坦克
                for(int i=0; i<enemyTanks.size(); i++) {
                    //取出第一个坦克
                    EnemyTank enemyTank=enemyTanks.get(i);
                    //如果不是自己
                    if (enemyTank != this) {
                        //如果敌人的方向是向下或者向上
                        if (enemyTank.direct == 0 || enemyTank.direct == 2) {
                            if (this.x+30 >= enemyTank.x && this.x+30 <= enemyTank.x + 20
                                    && this.y >= enemyTank.y && this.y <= enemyTank.y + 30) {
                                return true;
                            }
                            if (this.x + 30 >= enemyTank.x && this.x + 30 <= enemyTank.x + 20
                                    && this.y+20 >= enemyTank.y && this.y+20 <= enemyTank.y + 30) {
                                return true;
                            }
                        }
                        if (enemyTank.direct == 1 || enemyTank.direct == 3) {
                            if (this.x+30 >= enemyTank.x && this.x+30 <= enemyTank.x + 30
                                    && this.y >= enemyTank.y && this.y <= enemyTank.y + 20) {
                                return true;
                            }
                            if (this.x + 30 >= enemyTank.x && this.x + 30 <= enemyTank.x + 30
                                    && this.y+20 >= enemyTank.y && this.y+20 <= enemyTank.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                //我的坦克向下，取出所有敌人坦克
                for(int i=0; i<enemyTanks.size(); i++) {
                    //取出第一个坦克
                    EnemyTank enemyTank=enemyTanks.get(i);
                    //如果不是自己
                    if (enemyTank != this) {
                        //如果敌人的方向是向下或者向上
                        if (enemyTank.direct == 0 || enemyTank.direct == 2) {
                            if (this.x >= enemyTank.x && this.x <= enemyTank.x + 20
                                    && this.y+30 >= enemyTank.y && this.y+30 <= enemyTank.y + 30) {
                                return true;
                            }
                            if (this.x + 20 >= enemyTank.x && this.x + 20 <= enemyTank.x + 20
                                    && this.y+30 >= enemyTank.y && this.y+30 <= enemyTank.y + 30) {
                                return true;
                            }
                        }
                        if (enemyTank.direct == 1 || enemyTank.direct == 3) {
                            if (this.x >= enemyTank.x && this.x <= enemyTank.x + 30
                                    && this.y+30 >= enemyTank.y && this.y+30 <= enemyTank.y + 20) {
                                return true;
                            }
                            if (this.x + 20 >= enemyTank.x && this.x + 20 <= enemyTank.x + 30
                                    && this.y+30 >= enemyTank.y && this.y+30 <= enemyTank.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                //我的坦克向左，取出所有敌人坦克
                for(int i=0; i<enemyTanks.size(); i++) {
                    //取出第一个坦克
                    EnemyTank enemyTank=enemyTanks.get(i);
                    //如果不是自己
                    if (enemyTank != this) {
                        //如果敌人的方向是向下或者向上
                        if (enemyTank.direct == 0 || enemyTank.direct == 2) {
                            if (this.x >= enemyTank.x && this.x <= enemyTank.x + 20
                                    && this.y >= enemyTank.y && this.y <= enemyTank.y + 30) {
                                return true;
                            }
                            if (this.x >= enemyTank.x && this.x <= enemyTank.x + 20
                                    && this.y+20 >= enemyTank.y && this.y+20 <= enemyTank.y + 30) {
                                return true;
                            }
                        }
                        if (enemyTank.direct == 1 || enemyTank.direct == 3) {
                            if (this.x >= enemyTank.x && this.x <= enemyTank.x + 30
                                    && this.y >= enemyTank.y && this.y <= enemyTank.y + 20) {
                                return true;
                            }
                            if (this.x >= enemyTank.x && this.x <= enemyTank.x + 30
                                    && this.y+20 >= enemyTank.y && this.y+20 <= enemyTank.y + 20) {
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return  b;
    }


    @Override
    public void run() {
        while(true){
            switch (this.direct){
                case 0:
                    //说明坦克正在向上移动
                    for(int i=0; i<50; i++){
                        if(y>0 && !this.isTouchOtherEnemy()){
                            y-=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for(int i=0; i<50; i++){
                        if(x<400 && !this.isTouchOtherEnemy()){
                            x+=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for(int i=0; i<50; i++){
                        if(y<300 && !this.isTouchOtherEnemy()){
                            y+=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for(int i=0; i<50; i++){
                        if(x>0  && !this.isTouchOtherEnemy()){
                            x-=speed;
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            this.times++;
            if(times%2==0)
            {
                if(isLive){
                    if(ss.size()<5){
                        //没有子弹
                        Shot s=null;
                        //添加
                        switch (direct){
                            case 0:
                                s=new Shot(x+10,y,0);
                                ss.add(s);
                                break;
                            case 1:
                                s=new Shot(x+25,y+15,1);
                                ss.add(s);
                                break;
                            case 2:
                                s=new Shot(x+10,y+30,2);
                                ss.add(s);
                                break;
                            case 3:
                                s=new Shot(x-5,y+15,3);
                                ss.add(s);
                                break;
                        }

                        //启动子弹线程
                        Thread t=new Thread(s);
                        t.start();
                    }
                }

            }

            //让坦克随机产生新的方向
            this.direct=(int)(Math.random()*4);
            //判断敌人是否死亡
            if(this.isLive==false){
                //让坦克死亡后退出线程
                break;
            }



        }
    }
}

//我的坦克
class Hero extends Tank
{

    //子弹
//    Shot s=null;
    Vector<Shot> ss=new Vector<Shot>();
    Shot s=null;

    public Hero(int x, int y){
        super(x,y);
        this.x=200;
        this.y=100;
    }

    //开火
    public void shotEnemy()
    {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (this.direct){
            case 0:
                //创建一颗子弹
                s=new Shot(x+10,y,0);
                //把子弹放入Vector
                ss.add(s);
                break;
            case 1:
                s=new Shot(x+25,y+15,1);
                ss.add(s);
                break;
            case 2:
                s=new Shot(x+10,y+30,2);
                ss.add(s);
                break;
            case 3:
                s=new Shot(x-5,y+15,3);
                ss.add(s);
                break;
        }

        //启动子弹线程
        Thread t=new Thread(s);
        t.start();
    }



    //坦克向上移动
    public void moveUp()
    {
        y-=speed;
    }
    //坦克向右移动
    public void moveRight()
    {
        x+=speed;
    }
    //坦克向下移动
    public void moveDown()
    {
        y+=speed;
    }
    //坦克向左移动
    public void moveLeft()
    {
        x-=speed;
    }
}
