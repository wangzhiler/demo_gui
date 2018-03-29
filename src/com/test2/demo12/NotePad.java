package com.test2.demo12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Created by thinkpad on 2018/2/4.
 * 我的记事本（界面+功能）
 */


public class NotePad extends JFrame implements ActionListener{

    //定义需要的组件
    JTextArea jTextArea = null;

    //定义菜单条
    JMenuBar jMenuBar=null;
    //第一个JMenu
    JMenu jMenu1=null;
    //定义JMenuItem
    JMenuItem jMenuItem1=null;
    JMenuItem jMenuItem2=null;

    public static void main(String[] args) {

        NotePad notePad=new NotePad();

    }

    public NotePad(){
        //创建jTextArea
        jTextArea = new JTextArea();
        jMenuBar = new JMenuBar();
        jMenu1 = new JMenu("文件");
        //设置助记符
        jMenu1.setMnemonic('F');

        jMenuItem1 = new JMenuItem("打开",new ImageIcon("src\\file.png"));
        //注册监听
        jMenuItem1.addActionListener(this);
        jMenuItem1.setActionCommand("open");

        jMenuItem2 = new JMenuItem("保存");

        //对保存菜单处理
        jMenuItem2.addActionListener(this);
        jMenuItem2.setActionCommand("save");

        //加入
        this.setJMenuBar(jMenuBar);
        //把菜单放入JMebuBar
        jMenuBar.add(jMenu1);
        //把item放入menu
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);

        //放入到JFrame
        this.add(jTextArea);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //判断是哪个菜单被选中
        if (e.getActionCommand().equals("open")) {

            //文件选择组件
            JFileChooser jFileChooser1 = new JFileChooser();
            //设置名字
            jFileChooser1.setDialogTitle("请选择文件...");
            //默认方式
            jFileChooser1.showOpenDialog(null);
            //显示
            jFileChooser1.setVisible(true);

            //得到用户选择的文件全路径
            String filename = jFileChooser1.getSelectedFile().getAbsolutePath();

            FileReader fr=null;
            BufferedReader br=null;

            try {
                fr = new FileReader(filename);
                br = new BufferedReader(fr);

                //从文件中读取信息并显示到jta

                String s = "";
                String allCon = "";
                while ((s = br.readLine()) != null) {
                    allCon += s + "\r\n";

                }

                //放置大jta即可
                jTextArea.setText(allCon);

            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    br.close();
                    fr.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("save")) {
            //出现保存对话框
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("另存为...");
            //按默认方式显示
            jFileChooser.showSaveDialog(null);
            jFileChooser.setVisible(true);

            //得到用户希望把文件保存到何处，文件全路径
            String file = jFileChooser.getSelectedFile().getAbsolutePath();
            //准备写入指定文件
            FileWriter fw=null;
            BufferedWriter bw=null;
            try {
                fw = new FileWriter(file);
                bw = new BufferedWriter(fw);

                bw.write(this.jTextArea.getText());
            } catch (Exception e1) {
                e1.printStackTrace();
            } finally {
                try {
                    bw.close();
                    fw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

        }
    }
}




