package com.rivivo.ums.models.program;

public class programType extends programProperties {
    public programType(String name, String abbr) {
        super(name, abbr);
    }

    public static String getFilePath() {
        return "./data/programType_data.txt";
    }

    public void writeToFile() {
        super.writeToFile(getFilePath());
    }
}
