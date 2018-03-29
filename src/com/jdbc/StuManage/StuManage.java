package com.jdbc.StuManage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by thinkpad on 2018/2/14.
 */
public class StuManage extends JFrame implements ActionListener{

    //定义一些空间
    JPanel jPanel1, jPanel2;
    JLabel jLabel1;
    JButton jButton1, jButton2,jButton3, jButton4;
    JTable jTable;
    JScrollPane jScrollPane;
    JTextField jTextField;

//    Connection conn=null;
//    PreparedStatement preparedStatement=null;
//    ResultSet resultSet=null;

    StuModel stuModel=null;

    public static void main(String[] args) {
        StuManage a=new StuManage();
    }

    public StuManage(){
        jPanel1 = new JPanel();
        jTextField = new JTextField(10);

        jButton1 = new JButton("查询");
        jButton1.setActionCommand("query");
        jButton1.addActionListener(this);

        jLabel1 = new JLabel("请输入名字");
        //把各个控件加到JP1
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField);
        jPanel1.add(jButton1);

        jPanel2 = new JPanel();

        jButton2 = new JButton("添加");
        jButton2.setActionCommand("add");
        jButton2.addActionListener(this);

        jButton3 = new JButton("修改");
        jButton3.setActionCommand("amend");
        jButton3.addActionListener(this);

        jButton4 = new JButton("删除");
        jButton4.setActionCommand("delete");
        jButton4.addActionListener(this);
        //把各个按钮加入jp2
        jPanel2.add(jButton2);
        jPanel2.add(jButton3);
        jPanel2.add(jButton4);


        //创建一个数据模型对象
        StuModel stuModel=new StuModel();

        jTable = new JTable(stuModel);
        jScrollPane = new JScrollPane(jTable);

        this.add(jScrollPane);
        this.add(jPanel1, "North");
        this.add(jPanel2, "South");

        this.add(jScrollPane);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("query")) {
            //查询数据库，更新JTable
            //因为把对表的数据分装到stuModel中，我们就可以比较简答的完成查询
            String name=this.jTextField.getText().trim();
            //写一个sql语句
            String sql="select * from stu where stuName='"+name+"'";
            //构建新的数据模型类，并更新
            stuModel = new StuModel(sql);
            //更新JTable
            jTable.setModel(stuModel);

        }
        else if (e.getActionCommand().equals("add")) {
            StuAddDialog stuAddDialog = new StuAddDialog(this, "添加学生", true);
            //重新获得新的数据模型
            stuModel = new StuModel();
            //更新JTable
            jTable.setModel(stuModel);

        } else if (e.getActionCommand().equals("amend")) {
            //修改
            int rowNum=this.jTable.getSelectedRow();
            if (rowNum == -1) {
                JOptionPane.showMessageDialog(this, "请选择一行");
                return;
            }
            //显示修改对话框
            stuModel = new StuModel();

            new StuUpdateDialog(this, "修改学生", true, stuModel, rowNum);
            //更新JTable
            stuModel = new StuModel();
            jTable.setModel(stuModel);

        } else if (e.getActionCommand().equals("delete")) {
                //删除记录
                //1. 得到该学生的学号
                //getSelectedRow会返回用户点中的row
                //如果用户一个都没选会返回-1
                int rowNum = this.jTable.getSelectedRow();
                if (rowNum == -1) {
                    //提示
                    JOptionPane.showMessageDialog(this, "请选择一行");
                    return;
                }

                //得到学生编号
                stuModel = new StuModel();
                String stuId = (String) stuModel.getValueAt(rowNum, 0);

                //创建一个sql
            String sql="delete from stu where stuId=?";
            String[] paras = {stuId};
            StuModel temp = new StuModel();
            temp.updateStu(sql, paras);


                stuModel = new StuModel();
                //更新JTable
                jTable.setModel(stuModel);
            }
        }

}
