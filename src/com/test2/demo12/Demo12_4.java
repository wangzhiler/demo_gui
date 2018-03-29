package com.test2.demo12;

import java.io.*;

/**
 * Created by thinkpad on 2018/2/4.
 */
public class Demo12_4 {

    public static void main(String [] args){

        //思路：先把照片读入到内存 --》 写入某个文件
        //因为是二进制文件，因此只能用字节流完成

        //输入流
        FileInputStream fis=null;

        //输出流
        FileOutputStream fos=null;

        try {
            fis=new FileInputStream("D:\\a.gif");
            fos=new FileOutputStream("C:\\b.gif");

            byte buf[] = new byte[1024];
            int n=0;  //记录实际读取到的字节数
            //循环读取
            while ((n = fis.read(buf)) != -1) {
                //输出到指定文件
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //关闭打开的文件流
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
