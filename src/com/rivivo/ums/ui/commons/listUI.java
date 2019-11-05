package com.rivivo.ums.ui.commons;

import com.rivivo.ums.ui.header.titleBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class listUI {
    JPanel panel;
    ClickEventHandler clickHandler;

    public listUI(ClickEventHandler ch) {
        panel = new JPanel();
        clickHandler = ch;
    }

    abstract protected JTable getTable();

    JPanel getList() {
        JPanel p = new JPanel();
        BorderLayout b = new BorderLayout();
        b.setVgap(50);
        p.setLayout(b);

        JTable j = getTable();
        j.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(j);
        scrollPane.createHorizontalScrollBar();
        scrollPane.createVerticalScrollBar();
        scrollPane.setPreferredSize(new Dimension(400, 300));

        JPanel l = new JPanel();
        l.setLayout(new GridLayout(3, 1, 10, 50));
        JButton b1 = new JButton("Go Back");
        b1.setPreferredSize(new Dimension(100, 50));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
        l.add(b1);
        p.add(scrollPane, BorderLayout.CENTER);
        p.add(l, BorderLayout.SOUTH);
        return p;
    }

    JPanel main() {
        JPanel p = new JPanel();
        p.setSize(new Dimension(500, 300));
        p.setFont(new Font("Verdana", Font.PLAIN, 28));
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        p.add(getList());
        return p;
    }

    public JPanel getUI(String title) {
        panel.setLayout(new BorderLayout(3, 3));
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
