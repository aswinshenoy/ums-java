package com.rivivo.ums.ui.commons;

import com.rivivo.ums.ui.header.titleBar;

import javax.swing.*;
import java.awt.*;

public abstract class managerMenu {
    public JPanel panel;
    public JPanel menuGrid;
    public JPanel menu;
    public String label;
    ClickEventHandler clickHandler;

    public managerMenu(ClickEventHandler ch)
    {
        panel = new JPanel();
        menu = new JPanel();
        menuGrid = new JPanel();
        clickHandler = ch;
        generateMenu();
    }

    public managerMenu(ClickEventHandler ch, String l) {
        panel = new JPanel();
        menu = new JPanel();
        menuGrid = new JPanel();
        clickHandler = ch;
        label = l;
        generateMenu();
    }

    void generateMenu()
    {
        menu.setLayout(new FlowLayout());
        menu.setBackground(new Color(220, 220, 220));
        generateMenuGrid();
        menu.add(menuGrid);
    }

    public abstract void generateMenuGrid();

    public void reset() {
        panel.removeAll();
        titleBar t = new titleBar("Campus Manager");
        menu.setVisible(true);
        panel.add(t.getTitleBar(), BorderLayout.NORTH);
        panel.add(menu, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }

    public JPanel getUI(String text){
        panel.setLayout(new BorderLayout(3,3));
        titleBar t = new titleBar(text);

        panel.add(t.getTitleBar(), BorderLayout.NORTH);
        panel.add(menu, BorderLayout.CENTER);
        panel.setVisible(true);

        return panel;
    }

    public void onClick() {
        clickHandler.handleClick();
    }
}
