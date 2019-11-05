package com.rivivo.ums.ui.program.category;

import com.rivivo.ums.models.program.programCategory;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.createForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createCategoryUI extends createForm {

    JTextField nameField;
    JTextField abbrField;

    public createCategoryUI(ClickEventHandler ch) {
        super(ch);
    }

    @Override
    public JPanel getFormFields() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2, 5, 10));

        p.add(new JLabel("Name: "));
        nameField = new JTextField();
        p.add(nameField);

        p.add(new JLabel("Abbreviation: "));
        abbrField = new JTextField();
        p.add(abbrField);

        return p;
    }

    @Override
    public JPanel getButtons() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2, 10, 10));

        JButton b1 = new JButton("Go Back");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        });
        p.add(b1, BorderLayout.SOUTH);

        JButton b2 = new JButton("Add");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String abbr = abbrField.getText();
                String name = nameField.getText();
                if (!name.isEmpty() && !abbr.isEmpty()) {
                    programCategory c = new programCategory(name, abbr);
                    c.writeToFile();
                    onClick();
                }
            }
        });
        p.add(b2, BorderLayout.SOUTH);

        return p;
    }
}

