package com.rivivo.ums.ui.program.program;

import com.rivivo.ums.models.program.program;
import com.rivivo.ums.models.program.programCategory;
import com.rivivo.ums.models.program.programSpecialization;
import com.rivivo.ums.models.program.programType;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.FileHandler;
import com.rivivo.ums.ui.commons.createForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createProgramUI extends createForm {

    JTextField nameField;
    JTextField durationField;
    JComboBox category;
    JComboBox type;
    JComboBox specialization;
    JComboBox programCode;


    public createProgramUI(ClickEventHandler ch) {
        super(ch);
    }

    public JPanel getComboboxField(String text, JComboBox j, String[] options) {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1, 2));

        p.add(new JLabel(text));
        j = new JComboBox(options);
        p.add(j);
        return p;
    }


    @Override
    public JPanel getFormFields() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 2, 4, 10));

        p.add(new JLabel("Name: "));
        nameField = new JTextField();
        p.add(nameField);

        p.add(new JLabel("Duration: "));
        durationField = new JTextField();
        p.add(durationField);


        List pclines = FileHandler.readFileByLine(programCategory.getFilePath());
        List cats = new List();
        for (String x : pclines.getItems())
            cats.add(x.split(",")[1]);
        category = new JComboBox(cats.getItems());
        p.add(category);

        List ptlines = FileHandler.readFileByLine(programType.getFilePath());
        List types = new List();
        for (String x : ptlines.getItems())
            types.add(x.split(",")[1]);
        type = new JComboBox(types.getItems());
        p.add(type);


        List pslines = FileHandler.readFileByLine(programSpecialization.getFilePath());
        List specializations = new List();
        for (String x : pslines.getItems())
            specializations.add(x.split(",")[1]);
        specialization = new JComboBox(specializations.getItems());
        p.add(specialization);

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
                String dur = durationField.getText();
                String name = nameField.getText();
                System.out.println(category.getItemCount());
                String cat = String.valueOf(category.getSelectedItem());
                String ty = String.valueOf(type.getSelectedItem());
                String spl = String.valueOf(specialization.getSelectedItem());
                if (!name.isEmpty() && !dur.isEmpty() && !cat.isEmpty() && !ty.isEmpty() && !spl.isEmpty()) {
                    program p = new program(name, cat, ty, spl, Integer.parseInt(dur));
                    p.writeToFile();
                    onClick();
                }
            }
        });
        p.add(b2, BorderLayout.SOUTH);

        return p;
    }
}
