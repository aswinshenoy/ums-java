package com.rivivo.ums.ui.program;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.managerMenu;
import com.rivivo.ums.ui.commons.menuItem;
import com.rivivo.ums.ui.program.category.CategoryManagerUI;
import com.rivivo.ums.ui.program.program.programManUI;
import com.rivivo.ums.ui.program.specialization.SpecializationManagerUI;
import com.rivivo.ums.ui.program.type.TypeManagerUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClickHandler implements ClickEventHandler {
    ProgramManagerUI dispatcher;

    public ClickHandler(ProgramManagerUI i)
    {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}
public class ProgramManagerUI extends managerMenu {

    public ProgramManagerUI(ClickEventHandler ch) {
        super(ch);
    }

    public void generateMenuGrid() {
        menuGrid.setLayout(new GridLayout(2, 3, 10, 10));
        menuGrid.setBackground(null);
        ProgramManagerUI curr = this;
        menuItem b1 = new menuItem("Programs");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClickHandler ch = new ClickHandler(curr);
                programManUI Types = new programManUI(ch);
                menu.setVisible(false);
                panel.removeAll();
                panel.add(Types.getUI("Add Program"));
                panel.revalidate();
                panel.repaint();
            }
        });
        menuGrid.add(b1);

        menuItem b2 = new menuItem("Types");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClickHandler ch = new ClickHandler(curr);
                TypeManagerUI Types = new TypeManagerUI(ch);
                menu.setVisible(false);
                panel.removeAll();
                panel.add(Types.getUI("Add Types"));
                panel.revalidate();
                panel.repaint();
            }
        });
        menuGrid.add(b2);

        menuItem b3 = new menuItem("Specializations");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClickHandler ch = new ClickHandler(curr);
                SpecializationManagerUI Types = new SpecializationManagerUI(ch);
                menu.setVisible(false);
                panel.removeAll();
                panel.add(Types.getUI("Add Specializations"));
                panel.revalidate();
                panel.repaint();
            }
        });
        menuGrid.add(b3);

        menuItem b4 = new menuItem("Categories");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClickHandler ch = new ClickHandler(curr);
                CategoryManagerUI Types = new CategoryManagerUI(ch);
                menu.setVisible(false);
                panel.removeAll();
                panel.add(Types.getUI("Add Categories"));
                panel.revalidate();
                panel.repaint();
            }
        });
        menuGrid.add(b4);

        menuItem b5 = new menuItem("Go Back");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
        menuGrid.add(b5);
    }
}
