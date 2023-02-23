package com.rivivo.ums.models.program;

public class programCategory extends programProperties {
    public programCategory(String name, String abbr) {
        super(name, abbr);
    }

    public static String getFilePath() {
        return "./data/programCategory_data.txt";
    }

    public void writeToFile() {
        super.writeToFile(getFilePath());
    }
}
