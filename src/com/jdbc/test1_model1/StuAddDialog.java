package com.jdbc.test1_model1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by thinkpad on 2018/2/14.
 */
public class StuAddDialog extends JDialog implements ActionListener{
    //定义需要的控件
    JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6;
    JButton jButton1,jButton2;
    JTextField jTextField1, jTextField2, jTextField3,jTextField4,jTextField5,jTextField6;
    JPanel jPanel1,jPanel2,jPanel3;

    //owner父窗口
    //title 窗口名
    //modal 指定是模式窗口，还是非模式窗口
    public StuAddDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        jLabel1 = new JLabel("学号");
        jLabel2 = new JLabel("姓名");
        jLabel3 = new JLabel("性别");
        jLabel4 = new JLabel("年龄");
        jLabel5 = new JLabel("籍贯");
        jLabel6 = new JLabel("系别");

        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();

        jButton1 = new JButton("添加");
        jButton2 = new JButton("取消");

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();

        //设置布局
        jPanel1.setLayout(new GridLayout(6, 1));
        jPanel2.setLayout(new GridLayout(6, 1));

        //添加组件
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel2);
        jPanel1.add(jLabel3);
        jPanel1.add(jLabel4);
        jPanel1.add(jLabel5);
        jPanel1.add(jLabel6);

        jPanel2.add(jTextField1);
        jPanel2.add(jTextField2);
        jPanel2.add(jTextField3);
        jPanel2.add(jTextField4);
        jPanel2.add(jTextField5);
        jPanel2.add(jTextField6);

        jPanel3.add(jButton1);
        jPanel3.add(jButton2);

        this.add(jPanel1, BorderLayout.WEST);
        this.add(jPanel2, BorderLayout.CENTER);
        this.add(jPanel3, BorderLayout.SOUTH);

        jButton1.addActionListener(this);
        jButton1.setActionCommand("add");

        jButton2.addActionListener(this);
        jButton2.setActionCommand("cancel");

        this.setSize(300, 250);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("add")) {
            //连接数据库
            Connection conn=null;
//            Statement statement=null;
            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            //连接数据库
            try {
                //1. 加载驱动
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                //2. 连接对象
                String url="jdbc:sqlserver://localhost:1433;DatabaseName=spdb1";
                conn= DriverManager.getConnection(url,"sa","sa");
                //3. 获得语句对象
                String strsql="insert into stu values(?,?,?,?,?,?)";
                preparedStatement = conn.prepareStatement(strsql);

                //给参数赋值
                preparedStatement.setString(1, jTextField1.getText());
                preparedStatement.setString(2, jTextField2.getText());
                preparedStatement.setString(3, jTextField3.getText());
                preparedStatement.setString(4, jTextField4.getText());
                preparedStatement.setString(5, jTextField5.getText());
                preparedStatement.setString(6, jTextField6.getText());

                //4. 执行操作
                preparedStatement.executeUpdate();
                this.dispose(); //关闭对话框

            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    if(resultSet!=null) resultSet.close();
                    if(preparedStatement!=null) preparedStatement.close();
                    if(conn!=null) conn.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

        } else if (e.getActionCommand().equals("cancel")) {
            this.dispose();
        }
    }
}
