package com.rivivo.ums.models.program;

public class programSpecialization extends programProperties {
    public programSpecialization(String name, String abbr) {
        super(name, abbr);
    }

    public static String getFilePath() {
        return "./data/programSpecialization_data.txt";
    }

    public void writeToFile() {
        super.writeToFile(getFilePath());
    }
}
