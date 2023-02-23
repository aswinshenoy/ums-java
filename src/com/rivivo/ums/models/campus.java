package com.rivivo.ums.models;

import com.rivivo.ums.models.commons.property;

public class campus extends property {
    public campus(String name, String abbr) {
        super(name, abbr);
    }

    public static String getFilePath() {
        return "./data/campus_data.txt";
    }

    public void writeToFile() {
        super.writeToFile(getFilePath());
    }
}
