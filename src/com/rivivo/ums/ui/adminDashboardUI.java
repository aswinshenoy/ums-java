package com.rivivo.ums.ui;

import com.rivivo.ums.ui.campus.CampusManagerUI;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.menuItem;
import com.rivivo.ums.ui.header.titleBar;
import com.rivivo.ums.ui.login.Login;
import com.rivivo.ums.ui.program.ProgramManagerUI;
import com.rivivo.ums.ui.student.StudentManagerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClickHandler implements ClickEventHandler {
	adminDashboardUI dispatcher;

	public ClickHandler(adminDashboardUI i)
	{
		dispatcher = i;
	}

	public void handleClick() {
		dispatcher.reset();
	}
}

class LoginHandler implements ClickEventHandler {
    adminDashboardUI dispatcher;

    public LoginHandler(adminDashboardUI i) {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}

public class adminDashboardUI {

	JPanel dashboard;
	JPanel menu;
	JPanel menuGrid;

	public adminDashboardUI(){
		dashboard = new JPanel();
		menuGrid = new JPanel();
		menu = new JPanel();
		generateMenu();
	}

	void generateMenuGrid() {
		menuGrid.setLayout(new GridLayout(2,3,10,10));
		menuGrid.setBackground(null);
    	adminDashboardUI curr = this;
    	menuItem b1 = new menuItem("Campus Manager");
    	b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClickHandler ch = new ClickHandler(curr);
				CampusManagerUI campusManager = new CampusManagerUI(ch);
				menuGrid.setVisible(false);
				dashboard.removeAll();
				dashboard.add(campusManager.getUI("Campuses"));
				dashboard.revalidate();
				dashboard.repaint();
			}
		} );
		menuGrid.add(b1);
        
        menuItem b2 = new menuItem("Students");
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClickHandler ch = new ClickHandler(curr);
				StudentManagerUI studentManager = new StudentManagerUI(ch);
				menuGrid.setVisible(false);
				dashboard.removeAll();
				dashboard.add(studentManager.getUI("Student Manager"));
				dashboard.revalidate();
				dashboard.repaint();
			}
		} );
		menuGrid.add(b2);
        
        menuItem b3 = new menuItem("Programs");
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClickHandler ch = new ClickHandler(curr);
				ProgramManagerUI programManager = new ProgramManagerUI(ch);
				menuGrid.setVisible(false);
				dashboard.removeAll();
				dashboard.add(programManager.getUI("Program Manager"));
				dashboard.revalidate();
				dashboard.repaint();
			}
		} );
		menuGrid.add(b3);

        menuItem b4 = new menuItem("Courses");
		menuGrid.add(b4);

        menuItem b5 = new menuItem("Grades");
		menuGrid.add(b5);

        menuItem b6 = new menuItem("Logout");
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
		menuGrid.add(b6);
	}

	public void generateMenu() {
    	menu.setLayout(new FlowLayout());
    	menu.setBackground(new Color(220, 220, 220));
    	generateMenuGrid();
    	menu.add(menuGrid);
	}

	public void reset() {
		dashboard.removeAll();
		titleBar t = new titleBar("Admin Dashboard");
		menuGrid.setVisible(true);
		dashboard.add(t.getTitleBar(), BorderLayout.NORTH);
		dashboard.add(menu, BorderLayout.CENTER);
		dashboard.revalidate();
		dashboard.repaint();
	}

    public void logout() {
        dashboard.removeAll();
        adminDashboardUI curr = this;
        LoginHandler ch = new LoginHandler(curr);
        Login l = new Login(ch);
        dashboard.add(l.getLoginForm(), BorderLayout.CENTER);
        dashboard.revalidate();
        dashboard.repaint();
    }
	
	public JPanel getDashboard()
	{
    	dashboard.setLayout(new BorderLayout(3,3));
        logout();
    	return dashboard;
	}
}
