package com.test2.demos.demo7.test4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by thinkpad on 2018/1/31.
 */
public class FrameHaveDialog extends JFrame implements ActionListener{

    JTextArea text;
    JButton buttonFont;

    FrameHaveDialog(){
        buttonFont = new JButton("设置字体");
        text=new JTextArea("Java 2实用教程(第4版)");
        buttonFont.addActionListener(this);
        add(buttonFont, BorderLayout.NORTH);
        add(text);
        setBounds(60, 60, 300, 300);
        setVisible(true);
        validate();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonFont) {
            FontDialog dialog = new FontDialog(this);
            dialog.setVisible(true);
            if(dialog.getState()==FontDialog.YES){
                text.setFont(dialog.getFont());
                text.repaint();
            }
            if (dialog.getState() == FontDialog.NO) {
                text.repaint();
            }
        }
    }
}
