package com.test2.demos.demo7.test4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by thinkpad on 2018/1/31.
 */
public class FontDialog extends JDialog implements ItemListener,ActionListener{

    FontFamilyNames fontFamilyNames;
    int fontSize=38;
    String fontName;
    JComboBox fontNameList, fontSizeList;
    JLabel label;
    Font font;
    JButton yes, cancel;
    static int YES=1, NO=0;
    int state=-1;

    String font_Type;
    JComboBox fontType;

    FontDialog(JFrame f){
        super(f);
        setTitle("字体对话框");
        font=new Font("宋体",Font.PLAIN,12);
        fontFamilyNames=new FontFamilyNames();
        //1. 当前对话框调用setModal(boolean b)设置为有模式
        this.setModal(true);

        yes = new JButton("Yes");
        cancel = new JButton("cancel");
        yes.addActionListener(this);
        cancel.addActionListener(this);
        label = new JLabel("hello,奥运", JLabel.CENTER);
        fontNameList = new JComboBox();
        fontSizeList = new JComboBox();
        //////////////////////////////////
        fontType=new JComboBox();
        fontType.addItem("常规");
        fontType.addItem("加重");
        fontType.addItem("斜体");
        fontType.addItem("常规斜体");
        fontType.addItem("加重斜体");
        fontType.addItemListener(this);
        //////////////////////////////////
        String name[] = fontFamilyNames.getFontName();
        fontNameList.addItem("字体");
        for(int k=0; k<name.length; k++)
            fontNameList.addItem(name[k]);
        fontSizeList.addItem("大小");
        for(int k=8; k<72; k=k+2)
            fontSizeList.addItem(new Integer(k));
        fontNameList.addItemListener(this);
        fontSizeList.addItemListener(this);
        JPanel pNorth = new JPanel();
        pNorth.add(fontNameList);
        pNorth.add(fontSizeList);
        //////////////////////////////////
        pNorth.add(fontType);
        //////////////////////////////////
        add(pNorth, BorderLayout.NORTH);
        add(label, BorderLayout.CENTER);
        JPanel pSouth=new JPanel();
        pSouth.add(yes);
        pSouth.add(cancel);
        add(pSouth, BorderLayout.SOUTH);
        setBounds(100, 100, 500, 170);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        validate();
    }





    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == fontNameList) {
            fontName = (String) fontNameList.getSelectedItem();
            font = new Font(fontName, Font.PLAIN, fontSize);
        } else if (e.getSource() == fontSizeList) {
            Integer m=(Integer)fontSizeList.getSelectedItem();
            fontSize=m.intValue();
            font = new Font(fontName, Font.PLAIN, fontSize);
        } else if (e.getSource() == fontType) {
            font_Type=(String)fontType.getSelectedItem();
            if (font_Type.equals("常规")) {
                font = new Font(fontName, Font.PLAIN, fontSize);
            } else if (font_Type.equals("加重")) {
                font = new Font(fontName, Font.BOLD, fontSize);
            } else if (font_Type.equals("斜体")) {
                font = new Font(fontName, Font.ITALIC, fontSize);
            } else if (font_Type.equals("常规斜体")) {
                font = new Font(fontName, Font.PLAIN+ Font.ITALIC, fontSize);
            } else if (font_Type.equals("加重斜体")) {
                font = new Font(fontName, Font.BOLD+ Font.ITALIC, fontSize);
            }
        }
        label.setFont(font);
        label.repaint();
        validate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yes) {
            state=YES;
            //2. 对话框设置为不可见
            this.setVisible(false);
        } else if (e.getSource() == cancel) {
            state=NO;
            //3. 对话框设置为不可见
            this.setVisible(false);
        }
    }

    public int getState(){
        return state;
    }

    public Font getFont(){
        return font;
    }
}
