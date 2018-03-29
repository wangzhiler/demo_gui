package com.NetWork.qq1.qqClient.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by thinkpad on 2018/3/25.
 * qq客户端登录界面
 */
public class qqClientLogin extends JFrame{

    //定义北部需要的组件
    JLabel jlb1;

    //定义中部需要的组件
    //中部有三个JPanel 有一个叫选项卡窗口管理
    JTabbedPane jtp;
    JPanel jp2,jp3,jp4;
    JLabel jp2_jlb1,jp2_jlb2,jp2_jlb3,jp2_jlb4;
    JButton jp2_jb1;
    JTextField jp2_jtf;
    JPasswordField jp2_jpf;
    JCheckBox jp2_jcb1,jp2_jcb2;

    //定义南部需要的组件
    JPanel jp1;
    JButton jp1_jb1,jp1_jb2,jp1_jb3;

    public static void main(String[] args) {
        qqClientLogin qqClientLogin = new qqClientLogin();
    }

    public qqClientLogin() {
        //处理北部
        jlb1 = new JLabel(new ImageIcon("images/qq/tou.gif"));


        //处理中部
        jp2 = new JPanel(new GridLayout(3, 3));
        jp2_jlb1 = new JLabel("QQ号码",JLabel.CENTER);
        jp2_jlb2 = new JLabel("QQ密码",JLabel.CENTER);
        jp2_jlb3 = new JLabel("忘记密码",JLabel.CENTER);
        jp2_jlb3.setForeground(Color.blue);
        jp2_jlb4 = new JLabel("申请密码保护",JLabel.CENTER);
        jp2_jb1 = new JButton(new ImageIcon("images/qq/clear.gif"));
        jp2_jtf = new JTextField();
        jp2_jpf = new JPasswordField();
        jp2_jcb1 = new JCheckBox("隐身登录");
        jp2_jcb2 = new JCheckBox("记住密码");
        //把控件按顺序加入jp2
        jp2.add(jp2_jlb1);
        jp2.add(jp2_jtf);
        jp2.add(jp2_jb1);
        jp2.add(jp2_jlb2);
        jp2.add(jp2_jpf);
        jp2.add(jp2_jlb3);
        jp2.add(jp2_jcb1);
        jp2.add(jp2_jcb2);
        jp2.add(jp2_jlb4);
        //创建选项卡窗口
        jp3 = new JPanel();
        jp4 = new JPanel();


        jtp = new JTabbedPane();
        jtp.add("QQ", jp2);
        jtp.add("手机号码", jp3);
        jtp.add("电子邮件", jp4);


        //处理南部
        jp1 = new JPanel();
        jp1_jb1 = new JButton(new ImageIcon("images/qq/denglu.gif"));
        jp1_jb2 = new JButton(new ImageIcon("images/qq/quxiao.gif"));
        jp1_jb3 = new JButton(new ImageIcon("images/qq/xiangdao.gif"));
        jp1.add(jp1_jb1);
        jp1.add(jp1_jb2);
        jp1.add(jp1_jb3);


        this.setLayout(new BorderLayout());
        this.add(jlb1, "North");
        this.add(jtp, "Center");
        this.add(jp1, "South");
        this.setSize(350, 240);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
