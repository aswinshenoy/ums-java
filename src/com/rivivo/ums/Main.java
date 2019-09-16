package com.rivivo.ums;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;

import com.rivivo.ums.ui.*;
import com.rivivo.ums.ui.header.titleBar;

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
        
        f.setSize(800,600);
        f.setVisible(true);

//        campus amritapuri = new campus("Amritapuri","AM");
//
//        courseCategory eng = new courseCategory("Engineering", "EN");
//        courseType undergrad = new courseType("Undergraduate", "U");
//        courseSpecialization cse = new courseSpecialization("Computer Science & Engineering", "CSE");
//
//        course bcse = new course(
//                    "Bachelor of Technology",
//                    eng,
//                    undergrad,
//                    cse,
//                    4
//                );
//
//        student ashwin = new student(
//                    "Ashwin",
//                    "Shenoy",
//                    2018,
//                    amritapuri,
//                    bcse
//                );
//        System.out.println(ashwin.rollNumber);

    }
}
