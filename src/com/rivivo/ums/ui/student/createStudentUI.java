package com.rivivo.ums.ui.student;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.createForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class createStudentUI extends createForm {

    JTextField firstNameField;
    JTextField lastNameField;
    JTextField batchYear;
    JComboBox campusSelector;

    public JPanel getTextField(String text, JTextField j)
    {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,2));
        p.add(new JLabel(text));
        j = new JTextField();
        p.add(j);

        return p;
    }

    public JPanel getComboboxField(String text, JComboBox j, String[] options)
    {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,2));

        p.add(new JLabel(text));
        j = new JComboBox(options);
        p.add(j);
        return p;
    }

    public createStudentUI(ClickEventHandler ch) {
        super(ch);
    }

    public static List readFileByLine(String fileName) {
        List lines = new List();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                lines.add(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public JPanel getFormFields()
    {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,2,10,10));

        p.add(getTextField("First Name", firstNameField));
        p.add(getTextField("Last Name", lastNameField));
        p.add(getTextField("Batch Year", batchYear));

        List lines = readFileByLine("./data/campus_data.txt");
        List names = new List();
        for (String x : lines.getItems())
            names.add(x.split(",")[0]);
        p.add(getComboboxField("Campus",campusSelector,names.getItems()));

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
//                String abbr = abbrField.getText();
//                String name = nameField.getText();
//                if(!name.isEmpty() && !abbr.isEmpty())
//                {
//                    campus c = new campus(name,abbr);
                    onClick();
//                }
            }
        } );
        p.add(b2);

        return p;
    }


}
