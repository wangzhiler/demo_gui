package com.test2.demo11_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by thinkpad on 2018/2/4.
 */
public class Demo11_3 {

    public static void main(String []args){
        File f=new File("d:\\ss.txt");

        //字节输出流
        FileOutputStream fos=null;

        try {
            fos=new FileOutputStream(f);
            String s="hello world你好\r\n";
            String s1="啊哈哈哈哈";

            //定义字节数组
//            byte []bytes=new byte[1024];
            //如何把String→bytes数组
            fos.write(s.getBytes());
            fos.write(s1.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
