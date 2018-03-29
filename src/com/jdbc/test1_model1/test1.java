package com.jdbc.test1_model1;

import javax.swing.*;
import java.util.*;

/**
 * Created by thinkpad on 2018/2/14.
 * JTable的使用
 */
public class test1 extends JFrame {

    Vector rowData, columnNames;
    JTable jTable=null;
    JScrollPane jScrollPane=null;

    public static void main(String[] args) {
        test1 a=new test1();
    }

    //构造函数
    public test1(){
        columnNames=new Vector();
        //设置列名
        columnNames.add("学号");
        columnNames.add("名字");
        columnNames.add("性别");
        columnNames.add("年龄");
        columnNames.add("籍贯");
        columnNames.add("系列");
        //行数据
        rowData=new Vector();
        Vector hang=new Vector();
        hang.add("sp001");
        hang.add("孙悟空");
        hang.add("男");
        hang.add("500");
        hang.add("花果山");
        hang.add("少林寺");
        //加入到rowData
        rowData.add(hang);

        jTable = new JTable(rowData, columnNames);
        jScrollPane = new JScrollPane(jTable);
        //把jsp放到jframe
        this.add(jScrollPane);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
















