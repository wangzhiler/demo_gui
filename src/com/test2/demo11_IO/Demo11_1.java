package com.test2.demo11_IO;

import java.io.File;
import java.io.IOException;

/**
 * Created by thinkpad on 2018/1/28.
 */
public class Demo11_1 {

    public static void main(String []args){

//        //创建一个文件对象
//        File f=new File("d:\\aa.txt");
//
//        //得到文件路径
//        System.out.println("文件路径："+f.getAbsolutePath());
//        //得到文件大小,返回字节数
//        System.out.println("文件大小："+f.length());
//        System.out.println("可读："+f.canRead());

        //创建文件和创建文件夹
        /*
        File f=new File("d:\\a.txt");
        if(!f.exists()){
            //可以创建
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("有文件，不能创建");
        }*/

        /*
        File f=new File("d:\\ff");
        if (f.isDirectory()) {
            System.out.println("文件夹存在");
        } else {
            //创建
            f.mkdir();
        }*/

        //列出一个文件下面的所有文件
        File f=new File("d:\\Ubuntu");
        if (f.isDirectory()) {
            File lists[]=f.listFiles();
            for(int i=0; i<lists.length; i++){
                System.out.println("文件名："+lists[i].getName());
            }
        }
    }
}







