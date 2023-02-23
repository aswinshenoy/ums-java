package com.rivivo.ums;

import com.rivivo.ums.ui.adminDashboardUI;
import com.rivivo.ums.ui.header.titleBar;

import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new BorderLayout(3,3));
        titleBar t = new titleBar(
        				"University Management Suite (UMS)",
        				new Font("Sans-Serif", Font.BOLD, 20),
        				new Color(20,220,200)
        			);
        f.add(t.getTitleBar(), BorderLayout.NORTH);
        titleBar bottomBar = new titleBar(
                "S3 CSE Project by Akhil & Ashwin",
                new Font("Sans-Serif", Font.PLAIN, 12),
                new Color(10,120,200)
        );
        f.add(bottomBar.getTitleBar(), BorderLayout.SOUTH);
        adminDashboardUI d = new adminDashboardUI();
        f.add(d.getDashboard());

        f.setSize(1200, 800);
        f.setVisible(true);
    }
}
