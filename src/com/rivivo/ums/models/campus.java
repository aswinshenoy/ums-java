package com.rivivo.ums.models;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.rivivo.ums.models.commons.property;

public class campus extends property {
    public campus(String name, String abbr) {
        super(name, abbr);
        try {
            writeToFile();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void writeToFile() throws IOException {
        File f = new File("./data/campus_data.txt");
        if(!f.exists())
        {
            f.getParentFile().mkdirs();
        }
        FileWriter fw;
        fw = new FileWriter(f, true);
        fw.append(name + ',' + abbr + '\n');
        System.out.println("Campus added to file successfully");
        fw.close();

    }
}
