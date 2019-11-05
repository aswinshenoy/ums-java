package com.rivivo.ums.models.program;

import com.rivivo.ums.models.commons.property;
import com.rivivo.ums.ui.commons.FileHandler;

public class program extends property {
    private String name;
    private String category;
    private String type;
    private String specialization;
    private int duration;
    public String programCode;

    public program(String n, String c, String t, String s, int d)
    {
        name = n;
        category = c;
        type = t;
        specialization = s;
        duration = d;
        this.setProgramCode();
    }

    public static String getFilePath() {
        return "./data/program_data.txt";
    }

    public void writeToFile() {
        FileHandler.AppendLine(getFilePath(), name + ',' + category + ',' + type + ',' + specialization + +',' + duration);
    }

    public void setProgramCode()
    {
        programCode = category + '.' + type + duration + specialization;
    }
}

