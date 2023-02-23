package com.rivivo.ums.ui.program.category;

import com.rivivo.ums.models.program.programCategory;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.FileHandler;
import com.rivivo.ums.ui.commons.listUI;

import javax.swing.*;
import java.awt.*;

public class listCategoriesUI extends listUI {
    public listCategoriesUI(ClickEventHandler ch) {
        super(ch);
    }

    protected JTable getTable() {
        List specializations = FileHandler.readFileByLine(programCategory.getFilePath());
        String[][] data = new String[specializations.getItemCount()][2];
        int i = 0;
        for (String x : specializations.getItems()) {
            data[i][0] = x.split(",")[0];
            data[i][1] = x.split(",")[1];
            i++;
        }

        String[] columnNames = {"Specialization Name", "Specialization Code"};

        return new JTable(data, columnNames);
    }

}

