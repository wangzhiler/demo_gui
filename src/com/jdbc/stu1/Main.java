package com.jdbc.stu1;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.sun.corba.se.impl.naming.cosnaming.NamingContextImpl.debug;

/**
 * Created by thinkpad on 2018/3/6.
 */
public class Main extends JFrame implements ActionListener{

    private final JMenuBar jMenuBar;
    private final JMenu jMenu;
    private final JMenuItem jMenuItem1;
    private final JMenuItem jMenuItem2;
    private final JMenuItem jMenuItem3;

    public static void main(String[] args) {
        Main main=new Main();
    }

    public Main() {
        jMenuBar = new JMenuBar();
        jMenu = new JMenu("开始");
        jMenuItem1 = new JMenuItem("学生表管理");
        jMenuItem1.addActionListener(this);
        jMenuItem1.setActionCommand("stu");
        jMenuItem2 = new JMenuItem("课程表管理");
        jMenuItem2.addActionListener(this);
        jMenuItem2.setActionCommand("course");
        jMenuItem3 = new JMenuItem("选课表管理");
        jMenuItem3.addActionListener(this);
        jMenuItem3.setActionCommand("xuanke");

        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);
        jMenu.add(jMenuItem3);

        jMenuBar.add(jMenu);

        this.setJMenuBar(jMenuBar);

        //创建面板


        this.setVisible(true);
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("stu")) {
            StuManage stuManage = new StuManage();
        } else if (e.getActionCommand().equals("course")) {

        } else if (e.getActionCommand().equals("xuanke")) {

        } else{
        }
    }
}
