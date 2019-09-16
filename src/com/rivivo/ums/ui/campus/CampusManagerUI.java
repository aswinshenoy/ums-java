package com.rivivo.ums.ui.campus;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.managerMenu;
import com.rivivo.ums.ui.commons.menuItem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClickHandler implements ClickEventHandler {
    CampusManagerUI dispatcher;

    public ClickHandler(CampusManagerUI i)
    {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}

public class CampusManagerUI extends managerMenu {

    public CampusManagerUI(ClickEventHandler ch) {
        super(ch);
    }

    public void generateMenuGrid()
    {
        menuGrid.setLayout(new GridLayout(2,3,10,10));
        menuGrid.setBackground(null);
        CampusManagerUI curr = this;
        menuItem b1 = new menuItem("Add Campus");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClickHandler ch = new ClickHandler(curr);
                createCampusUI campus = new createCampusUI(ch);
                menu.setVisible(false);
                panel.removeAll();
                panel.add(campus.getUI("Add Campus"));
                panel.revalidate();
                panel.repaint();
            }
        } );
        menuGrid.add(b1);

        menuItem b2 = new menuItem("View Campus");
        menuGrid.add(b2);

        menuItem b3 = new menuItem("Edit/Remove Campus");
        menuGrid.add(b3);

        menuItem b4 = new menuItem("Campus Stats");
        menuGrid.add(b4);

        menuItem b5 = new menuItem("Go Back");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        } );
        menuGrid.add(b5);
    }
}
