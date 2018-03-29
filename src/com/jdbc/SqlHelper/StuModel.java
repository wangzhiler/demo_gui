package com.jdbc.SqlHelper;

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

    //添加学生 增加 删除 改动
    public boolean updateStu(String sql, String []paras) {
        //创建SqlHelper  如果程序并发性不考虑，可以吧SqlHelper做成static
        SqlHelper sqlHelper = new SqlHelper();
        return sqlHelper.upExecute(sql, paras);
    }

    //查询(本质就是初始化)
    public void queryStu(String sql,String []paras){

        SqlHelper sqlHelper=null;
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
            sqlHelper=new SqlHelper();
            ResultSet resultSet = sqlHelper.queryExecute(sql, paras);


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
            sqlHelper.close();
        }
    }

    public StuModel(){}


    //做一个构造函数，用于初始化我们的数据模型
    public StuModel(String sql)
    {

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
