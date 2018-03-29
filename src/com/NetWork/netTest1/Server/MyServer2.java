package com.NetWork.netTest1.Server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Created by thinkpad on 2018/3/25.
 * function:
 * Server端，在9999端口上监听
 * 可以通过控制台，输入会送给客户端的信息
 */
public class MyServer2 {
    public static void main(String[] args) {
        MyServer2 myServer2 = new MyServer2();
    }

    public MyServer2()
    {
        //在9999端口监听
        try {
            System.out.println("服务器在9999监听...");

            ServerSocket ss = new ServerSocket(9999);

            //等待连接
            Socket s = ss.accept();
            //先接受客户端发来的信息
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            PrintWriter pw = new PrintWriter(s.getOutputStream(), true);

            //接受从控制台输入的信息
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String infoFromClient = br.readLine();
                System.out.println("客户端发来：" + infoFromClient);

                if (infoFromClient.equals("bye")) {
                    System.out.println("Server over");

                    s.close();
                    break;
                }

                //接受从控制台输入的信息
                System.out.println("输入你希望对客户端说的话：");
                String response=scanner.nextLine();
                //把从控制台接受的信息，会送给客户端
                pw.println(response);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
