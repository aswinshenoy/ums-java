package com.rivivo.ums.models;

import com.rivivo.ums.models.program.program;
import com.rivivo.ums.ui.commons.FileHandler;

public class student {
    public static int studentIndex = 1;

    public String rollNumber;
    private String firstName;
    private String lastName;
    private int batchYear;
    private program program;
    private campus campus;

    public student(String fn, String ln, int y, campus c, program p)
    {
        firstName = fn;
        lastName = ln;
        batchYear = y;
        campus = c;
        program = p;
        generateRollNumber();
    }

    public void generateRollNumber()
    {
        studentIndex = FileHandler.readFileByLine(getFilePath()).getItemCount() + 1;
        rollNumber = campus.abbr + '.' + program.programCode + batchYear%100 + String.format("%03d", studentIndex);
        studentIndex++;
    }

    public static String getFilePath() {
        return "./data/student_data.txt";
    }

    public void writeToFile() {
        FileHandler.AppendLine(getFilePath(), firstName + ',' + lastName + ',' + rollNumber);
    }
}
