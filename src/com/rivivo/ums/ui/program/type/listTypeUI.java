package com.rivivo.ums.ui.program.type;

import com.rivivo.ums.models.program.programType;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.FileHandler;
import com.rivivo.ums.ui.commons.listUI;

import javax.swing.*;
import java.awt.*;

public class listTypeUI extends listUI {

    public listTypeUI(ClickEventHandler ch) {
        super(ch);
    }

    protected JTable getTable() {
        List types = FileHandler.readFileByLine(programType.getFilePath());
        String[][] data = new String[types.getItemCount()][2];
        int i = 0;
        for (String x : types.getItems()) {
            data[i][0] = x.split(",")[0];
            data[i][1] = x.split(",")[1];
            i++;
        }

        String[] columnNames = {"Type Name", "Type Code"};

        return new JTable(data, columnNames);
    }

}
