package com.rivivo.ums.models.program;

public class program {
    private String name;
    private programCategory category;
    private programType type;
    private programSpecialization specialization;
    private int duration;
    public String programCode;

    public program(String n, programCategory c, programType t, programSpecialization s, int d)
    {
        name = n;
        category = c;
        type = t;
        specialization = s;
        duration = d;
        this.setProgramCode();
    }

    public void setProgramCode()
    {
        programCode = category.abbr + '.' + type.abbr + duration + specialization.abbr;
    }
}

