package com.rivivo.ums.ui.program.program;

import com.rivivo.ums.models.program.program;
import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.FileHandler;
import com.rivivo.ums.ui.commons.listUI;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;

public class listProgramUI extends listUI {

    public listProgramUI(ClickEventHandler ch) {
        super(ch);
    }

    protected JTable getTable() {
        List types = FileHandler.readFileByLine(program.getFilePath());
        String[][] data = new String[types.getItemCount()][5];
        int i = 0;
        for (String x : types.getItems()) {
            data[i][0] = x.split(",")[0];
            data[i][1] = x.split(",")[1];
            data[i][2] = x.split(",")[2];
            data[i][3] = x.split(",")[3];
            data[i][4] = x.split(",")[4];
            i++;
        }

        String[] columnNames = {"Program Name", "Category", "Type", "Specialization", "Duration"};
        JTable t = new JTable(data, columnNames);
        TableColumn col = t.getColumnModel().getColumn(2);
        col.setPreferredWidth(200);
        return t;
    }

}
