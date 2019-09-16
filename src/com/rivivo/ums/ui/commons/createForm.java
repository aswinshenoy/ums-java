package com.rivivo.ums.ui.commons;

import com.rivivo.ums.ui.header.titleBar;

import javax.swing.*;
import java.awt.*;

public abstract class createForm {
    JPanel panel;
    ClickEventHandler clickHandler;

    public createForm(ClickEventHandler ch)
    {
        panel = new JPanel();
        clickHandler = ch;
    }

    public abstract JPanel getFormFields();

    public abstract JPanel getButtons();

    JPanel entryForm(){
        JPanel p =new JPanel();
        p.setLayout(new BorderLayout());
        p.add(getFormFields(), BorderLayout.CENTER);
        p.add(getButtons(), BorderLayout.SOUTH);
        return p;
    }

    JPanel main(){
        JPanel p = new JPanel();
        p.setSize(new Dimension(500, 300));
        p.setFont(new Font("Verdana",Font.PLAIN,28));
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        p.add(entryForm());

        return p;
    }

    public JPanel getUI(String title){
        panel.setLayout(new BorderLayout(3,3));
        titleBar t = new titleBar(title);

        panel.add(t.getTitleBar(), BorderLayout.NORTH);
        panel.add(main(), BorderLayout.CENTER);
        panel.setVisible(true);

        return panel;
    }

    public void onClick() {
        clickHandler.handleClick();
    }

}
