package com.jdbc.demo1;

import java.sql.*;

/**
 * Created by thinkpad on 2018/2/14.
 */
public class test2 {
    public static void main(String[] args) {
        //定义需要的对象
        PreparedStatement preparedStatement=null;
        Connection connection=null;
        ResultSet resultSet=null;

        try {
            //加载驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //得到连接
            //127.0.0.1表示你要连接的数据库的ip
            //1433表示sql server的默认端口
            //
            connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=spdb1"
                    ,"sa","sa");
            //创建ps，创建数据
//            preparedStatement = connection.prepareStatement("create database vvv");
            preparedStatement=connection.prepareStatement("backup database school to disk='d:/sch.bak'");

            //如果执行的是ddl语句
            //返回布尔值
            boolean b=preparedStatement.execute();
            if (!b) {
                System.out.println("ok");
            }else{
                System.out.println("error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(preparedStatement!=null){
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
