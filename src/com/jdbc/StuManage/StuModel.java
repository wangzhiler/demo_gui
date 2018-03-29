package com.jdbc.StuManage;

import javax.swing.table.AbstractTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 * Created by thinkpad on 2018/2/14.
 * 这是我的一个stu表模型
 */
public class StuModel extends AbstractTableModel {


    Vector rowData, columNames;
//    JTable jTable=null;
//    JScrollPane jScrollPane=null;
    //定义操作数据库需要的东西
    PreparedStatement preparedStatement=null;
    Connection connection=null;
    ResultSet resultSet=null;
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url="jdbc:sqlserver://localhost:1433;DatabaseName=spdb1";
    String user="sa";
    String password="sa";

    //添加学生 增肌 删除 改动
    public boolean updateStu(String sql, String []paras) {
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

        return b;
    }

    public void init(String sql){
        if (sql.equals("")) {
            sql = "SELECT * from stu";
        }

        //中间
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
            Class.forName(driver);
            connection= DriverManager.getConnection(url,user,password);
            preparedStatement = connection.prepareStatement(sql);
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
    }




    //通过传递的sql语句来获得数据模型
    public StuModel(String sql) {
       this.init(sql);
    }

    //做一个构造函数，用于初始化我们的数据模型
    public StuModel()
    {
        this.init("");
    }

    @Override
    public String getColumnName(int column) {
        return (String)this.columNames.get(column);
    }

    //得到共有多少换行
    @Override
    public int getRowCount() {
        return this.rowData.size();
    }


    //得到共有多少列
    @Override
    public int getColumnCount() {
        return this.columNames.size();
    }

    //得到某行某列数据
    @Override
    public Object getValueAt(int row, int column) {
        return ((Vector)this.rowData.get(row)).get(column);
    }
}
