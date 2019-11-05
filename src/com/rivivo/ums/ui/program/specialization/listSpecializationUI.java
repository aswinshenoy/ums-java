package com.rivivo.ums.ui.program.specialization;

import com.rivivo.ums.models.program.programSpecialization;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.FileHandler;
import com.rivivo.ums.ui.commons.listUI;

import javax.swing.*;
import java.awt.*;

public class listSpecializationUI extends listUI {
    public listSpecializationUI(ClickEventHandler ch) {
        super(ch);
    }

    protected JTable getTable() {
        List specializations = FileHandler.readFileByLine(programSpecialization.getFilePath());
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
