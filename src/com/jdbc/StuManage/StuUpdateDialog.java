package com.jdbc.StuManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by thinkpad on 2018/2/15.
 */
public class StuUpdateDialog extends JDialog implements ActionListener {
    //定义需要的控件
    JLabel jLabel1,jLabel2,jLabel3,jLabel4,jLabel5,jLabel6;
    JButton jButton1,jButton2;
    JTextField jTextField1, jTextField2, jTextField3,jTextField4,jTextField5,jTextField6;
    JPanel jPanel1,jPanel2,jPanel3;

    //owner父窗口
    //title 窗口名
    //modal 指定是模式窗口，还是非模式窗口
    public StuUpdateDialog(Frame owner, String title, boolean modal, StuModel stuModel, int rowNums) {
        super(owner, title, modal);
        jLabel1 = new JLabel("学号");
        jLabel2 = new JLabel("姓名");
        jLabel3 = new JLabel("性别");
        jLabel4 = new JLabel("年龄");
        jLabel5 = new JLabel("籍贯");
        jLabel6 = new JLabel("系别");

        jTextField1 = new JTextField();
        jTextField1.setText((String)stuModel.getValueAt(rowNums,0));
        //让jtf1不能修改
        jTextField1.setEditable(false);

        jTextField2 = new JTextField();
        jTextField2.setText((String)stuModel.getValueAt(rowNums,1));
        jTextField3 = new JTextField();
        jTextField3.setText((String)stuModel.getValueAt(rowNums,2));
        jTextField4 = new JTextField();
        jTextField4.setText(stuModel.getValueAt(rowNums,3).toString());
        jTextField5 = new JTextField();
        jTextField5.setText((String)stuModel.getValueAt(rowNums,4));
        jTextField6 = new JTextField();
        jTextField6.setText((String)stuModel.getValueAt(rowNums,5));

        jButton1 = new JButton("修改");


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
        jButton1.setActionCommand("amend");

        jButton2.addActionListener(this);
        jButton2.setActionCommand("cancel");

        this.setSize(300, 250);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("amend")) {


            String strsql="update stu set stuName=?, stuSex=?" +
                    ",stuAge=?,stuJg=?,stuDept=? where stuId=?";
            String []paras={jTextField2.getText(),jTextField3.getText()
                    ,jTextField4.getText(),jTextField5.getText()
                    ,jTextField6.getText(),jTextField1.getText()};
            StuModel temp = new StuModel();
            temp.updateStu(strsql, paras);

            this.dispose();

        } else if (e.getActionCommand().equals("cancel")) {
            this.dispose();
        }
    }
}
