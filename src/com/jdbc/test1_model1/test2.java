package com.jdbc.test1_model1;


import javax.swing.*;
import java.sql.*;
import java.util.*;

/**
 * Created by thinkpad on 2018/2/14.
 */
public class test2 extends JFrame{
    Vector rowData, columNames;
    JTable jTable=null;
    JScrollPane jScrollPane=null;
    //定义操作数据库需要的东西
    PreparedStatement preparedStatement=null;
    Connection connection=null;
    ResultSet resultSet=null;

    public static void main(String[] args) {
        test2 a=new test2();
    }

    public test2(){
        columNames=new Vector();
        columNames.add("学号");
        columNames.add("名字");
        columNames.add("性别");
        columNames.add("年龄");
        columNames.add("籍贯");
        columNames.add("系别");

        rowData=new Vector();

        try {
            //加在驱动
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=spdb1"
                    ,"sa","sa");
            preparedStatement = connection.prepareStatement("select * from stu");
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector hang = new Vector();
                hang.add(resultSet.getString(1));
                hang.add(resultSet.getString(2));
                hang.add(resultSet.getString(3));
                hang.add(resultSet.getInt(4));
                hang.add(resultSet.getString(5));
                hang.add(resultSet.getString(6));

                rowData.add(hang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

        jTable = new JTable(rowData, columNames);
        jScrollPane = new JScrollPane(jTable);

        this.add(jScrollPane);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
