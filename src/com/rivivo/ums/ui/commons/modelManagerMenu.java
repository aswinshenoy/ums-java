package com.rivivo.ums.ui.commons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class modelManagerMenu extends managerMenu {
    public String name;

    public modelManagerMenu(ClickEventHandler ch, String n) {
        super(ch, n);
    }

    public abstract void onClickAddNew(modelManagerMenu curr);
    public abstract void onClickShow(modelManagerMenu curr);

    public void generateMenuGrid() {
        menuGrid.setLayout(new GridLayout(2, 3, 10, 10));
        menuGrid.setBackground(null);
        modelManagerMenu curr = this;
        System.out.println(this.label);
        menuItem b1 = new menuItem("Add new " + label);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickAddNew(curr);
            }
        });
        menuGrid.add(b1);

        menuItem b2 = new menuItem("Edit/Remove " + label + 's');
        menuGrid.add(b2);

        menuItem b3 = new menuItem("Show " + label + 's');
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickShow(curr);
            }
        });
        menuGrid.add(b3);

        menuItem b4 = new menuItem("Go Back", new Color(220, 120, 120));
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
        menuGrid.add(b4);
    }
}
