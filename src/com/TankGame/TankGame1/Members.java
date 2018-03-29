package com.TankGame.TankGame1;

/**
 * Created by thinkpad on 2018/1/20.
 */

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
            System.out.println("子弹坐标"+x+"  "+y);

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

//敌人的坦克
class EnemyTank extends Tank
{

    public EnemyTank(int x, int y) {
        super(x, y);
    }
}

//我的坦克
class Hero extends Tank
{

    //子弹
    Shot s=null;

    public Hero(int x, int y){
        super(x,y);
    }

    //开火
    public void shotEnemy()
    {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (this.direct){
            case 0:
                s=new Shot(x+10,y,0);
                break;
            case 1:
                s=new Shot(x+25,y+15,1);
                break;
            case 2:
                s=new Shot(x+10,y+30,2);
                break;
            case 3:
                s=new Shot(x-5,y+15,3);
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
