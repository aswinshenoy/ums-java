package com.rivivo.ums.models.commons;

import com.rivivo.ums.ui.commons.FileHandler;

public class property {
    public String name;
    public String abbr;

    public property() {
        super();
    }

    public property(String name, String abbr) {
        this.name = name;
        this.abbr = abbr;
    }

    public void writeToFile(String path) {
        FileHandler.AppendLine(path, name + ',' + abbr);
    }

}