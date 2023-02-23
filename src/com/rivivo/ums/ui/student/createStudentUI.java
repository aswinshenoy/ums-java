package com.rivivo.ums.ui.student;

import com.rivivo.ums.models.campus;
import com.rivivo.ums.models.program.program;
import com.rivivo.ums.models.student;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.FileHandler;
import com.rivivo.ums.ui.commons.createForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class createStudentUI extends createForm {

    JTextField firstNameField;
    JTextField lastNameField;
    JTextField batchYear;
    JComboBox campusSelector;
    JComboBox programSelector;
    ArrayList campuses;
    ArrayList programs;

    public createStudentUI(ClickEventHandler ch) {
        super(ch);
    }

    @Override
    public JPanel getFormFields()
    {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5, 2, 10, 10));

        p.add(new JLabel("First Name: "));
        firstNameField = new JTextField();
        p.add(firstNameField);

        p.add(new JLabel("Last Name: "));
        lastNameField = new JTextField();
        p.add(lastNameField);

        p.add(new JLabel("Admission Year: "));
        batchYear = new JTextField();
        p.add(batchYear);

        p.add(new JLabel("Campus: "));
        List lines = FileHandler.readFileByLine(campus.getFilePath());
        List names = new List();
        campuses = new ArrayList();
        for (String x : lines.getItems()) {
            names.add(x.split(",")[0]);
            campuses.add(new campus(x.split(",")[0], x.split(",")[1]));
        }
        campusSelector = new JComboBox(names.getItems());
        p.add(campusSelector);

        p.add(new JLabel("Program: "));
        List pclines = FileHandler.readFileByLine(program.getFilePath());
        List cats = new List();
        programs = new ArrayList();
        for (String x : pclines.getItems()) {
            cats.add(x.split(",")[0]);
            programs.add(new program(
                    x.split(",")[0],
                    x.split(",")[1],
                    x.split(",")[2],
                    x.split(",")[3],
                    Integer.parseInt(x.split(",")[4])
            ));
        }
        programSelector = new JComboBox(cats.getItems());
        p.add(programSelector);

        return p;
    }

    @Override
    public JPanel getButtons()
    {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,2,10,10));

        JButton b1 = new JButton("Go Back");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
        } );
        p.add(b1);

        JButton b2 =new JButton("Add");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                int batchyear = Integer.parseInt(batchYear.getText());
                int pi = programSelector.getSelectedIndex();
                int ci = campusSelector.getSelectedIndex();
                if (!firstName.isEmpty() && !lastName.isEmpty() && !batchYear.getText().isEmpty() && pi != -1 && ci != -1) {
                    program program = (program) programs.get(pi);
                    campus campus = (campus) campuses.get(ci);
                    student s = new student(firstName, lastName, batchyear, campus, program);
                    s.writeToFile();
                    onClick();
                }
            }
        } );
        p.add(b2);

        return p;
    }


}
