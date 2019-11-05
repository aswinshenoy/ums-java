package com.rivivo.ums.ui.student;

import com.rivivo.ums.models.student;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.FileHandler;
import com.rivivo.ums.ui.commons.listUI;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;


public class listStudentUI extends listUI {

    public listStudentUI(ClickEventHandler ch) {
        super(ch);
    }

    protected JTable getTable() {
        List types = FileHandler.readFileByLine(student.getFilePath());
        String[][] data = new String[types.getItemCount()][3];
        int i = 0;
        for (String x : types.getItems()) {
            data[i][0] = x.split(",")[0];
            data[i][1] = x.split(",")[1];
            data[i][2] = x.split(",")[2];
            i++;
        }

        String[] columnNames = {"First Name", "Last Name", "Roll Number"};
        JTable t = new JTable(data, columnNames);
        TableColumn col = t.getColumnModel().getColumn(2);
        col.setPreferredWidth(200);
        return t;
    }

}
