package com.test2.demo12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by thinkpad on 2018/2/4.
 */
public class Demo12_5 {

    public static void main(String [] args) {

        //文件取出的字符流对象
        FileReader fr=null;
        //写入到文件
        FileWriter fw=null;

        try {
            //创建fr对象
            fr = new FileReader("C:\\test.txt");
            //创建输出对象
            fw = new FileWriter("D:\\a.txt");

            int n=0;  //记录实际读取的字符数
            //读入到内存
            char c[] = new char[1024];
            while ((n = fr.read(c)) != -1) {
//                String s=new String(c,0,n);
                fw.write(c,0,n);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
