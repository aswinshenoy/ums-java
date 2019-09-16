package com.rivivo.ums.ui.header;

import javafx.css.Size;

import java.awt.*;
import javax.swing.*;

public class titleBar{

    public String title;
    public Font font;
    public Color background;

    public titleBar(String title)
    {
        this.title = title;
        font = new Font("Sans-Serif", Font.BOLD, 25);
        background = new Color(200,220,200);
    }
    
    public titleBar(String title, Font f, Color bg)
    {
    	this.title = title;
    	font = f;
    	background = bg;
    }

    private JLabel getTitle(){
        JLabel l = new JLabel(title);
        l.setHorizontalAlignment(JLabel.LEFT);
        l.setFont(font);
        return l;
    }

    public JPanel getTitleBar(){
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout(20,20));
        p.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        p.setBackground(background);
        p.add(getTitle(), BorderLayout.CENTER);
        return p;
    }
}