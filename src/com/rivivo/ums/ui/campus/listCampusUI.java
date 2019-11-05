package com.rivivo.ums.ui.campus;

import com.rivivo.ums.models.campus;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.FileHandler;
import com.rivivo.ums.ui.commons.listUI;

import javax.swing.*;
import java.awt.*;

public class listCampusUI extends listUI {

    public listCampusUI(ClickEventHandler ch) {
        super(ch);
    }

    protected JTable getTable() {
        List campuses = FileHandler.readFileByLine(campus.getFilePath());
        String[][] data = new String[campuses.getItemCount()][2];
        int i = 0;
        for (String x : campuses.getItems()) {
            data[i][0] = x.split(",")[0];
            data[i][1] = x.split(",")[1];
            i++;
        }

        String[] columnNames = {"Campus Name", "Campus Code"};

        return new JTable(data, columnNames);
    }

}
