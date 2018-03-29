package com.jdbc.SqlHelper;

import java.sql.*;

/**
 * Created by thinkpad on 2018/2/15.
 */
public class SqlHelper {

    //定义操作数据库需要的东西
    PreparedStatement preparedStatement=null;
    Connection connection=null;
    ResultSet resultSet=null;
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://localhost:1433;DatabaseName=spdb1";
    String user="sa";
    String password="sa";

    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet queryExecute(String sql) {
        try {
            //加在驱动 得到连接 创建ps 执行操作
            Class.forName(driver);
            connection=DriverManager.getConnection(url,user,password);
            preparedStatement = connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return  resultSet;
    }

    //查询
    public ResultSet queryExecute(String sql,String []paras) {
        try {
            //加在驱动 得到连接 创建ps 执行操作
            Class.forName(driver);
            connection=DriverManager.getConnection(url,user,password);
            preparedStatement = connection.prepareStatement(sql);
            //给ps的问号赋值
            for(int i=0; i<paras.length; i++) {
                preparedStatement.setString(i + 1, paras[i]);
            }
            resultSet=preparedStatement.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

        return resultSet;
    }


    //把增删改何在一起
    public boolean upExecute(String sql, String []paras){
        boolean b=true;

        try {

            //加在驱动 得到连接 创建ps 执行操作
            Class.forName(driver);
            connection=DriverManager.getConnection(url,user,password);
            preparedStatement = connection.prepareStatement(sql);
            //给ps的问号赋值
            for(int i=0; i<paras.length; i++) {
                preparedStatement.setString(i + 1, paras[i]);
            }
            if (preparedStatement.executeUpdate() != 1) {
                b=false;
            }

        } catch (Exception e) {
            b=false;
            e.printStackTrace();
        } finally {
            this.close();
        }

        return b;
    }


}
