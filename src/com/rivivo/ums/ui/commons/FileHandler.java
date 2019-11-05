package com.rivivo.ums.ui.commons;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandler {
    public static List readFileByLine(String fileName) {
        List lines = new List();
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNext()) {
                lines.add(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static boolean checkExist(String filePath, String line) {
        List lines = readFileByLine(filePath);
        for (String l : lines.getItems())
            if (l.toLowerCase().equals(line.toLowerCase()))
                return true;
        return false;
    }

    public static void AppendLine(String filePath, String line) {
        if (!checkExist(filePath, line)) {
            try {
                File f = new File(filePath);
                if (!f.exists())
                    f.getParentFile().mkdirs();
                FileWriter fw;
                fw = new FileWriter(f, true);
                fw.append(line + "\n");
                System.out.println("Object written to file successfully");
                fw.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        } else
            System.out.println("Object already exists in file");
    }
}
