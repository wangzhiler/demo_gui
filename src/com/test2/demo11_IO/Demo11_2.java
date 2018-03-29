package com.test2.demo11_IO;

import java.io.*;

/**
 * Created by thinkpad on 2018/2/4.
 */
public class Demo11_2 {

    public static void main(String []args){

        File f=new File("d:\\test.txt");
        FileInputStream fis=null;

        //因为File没有读写能力，所以需要使用InputStream流
        try {
            fis = new FileInputStream(f);

            //定义一个字节数组
            byte [] bytes=new byte[1024];
            int n=0;  //实际读取到的字节数

            //循环读取
            while((n=fis.read(bytes))!=-1){
                //把字节转成string
                String s=new String(bytes, 0, n);
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭文件流必须放这里
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
