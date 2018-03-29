package com.NetWork.netTest1.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

/**
 * Created by thinkpad on 2018/3/25.
 */
public class MyClient2 {

    public static void main(String[] args) {
        MyClient2 myClient2 = new MyClient2();
    }

    public MyClient2() {
        try {
            Socket s = new Socket("127.0.0.1", 9999);
            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

            Scanner scanner = new Scanner(System.in);

            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);


            while (true) {
                System.out.println("请输入你想对服务器说的话");
                //客户端先从控制台接受
                String info = scanner.nextLine();
                //然后发送给服务器
                pw.println(info);

                if (info.equals("bye")) {
                    System.out.println("Client over");

                    s.close();
                    break;
                }


                //接受服务器发来的话
                String res = br.readLine();
                System.out.println("Server说：" + res);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
