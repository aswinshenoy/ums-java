package com.rivivo.ums.ui.student;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.modelManagerMenu;

class ClickHandler implements ClickEventHandler {
    StudentManagerUI dispatcher;

    public ClickHandler(StudentManagerUI i)
    {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}

public class StudentManagerUI extends modelManagerMenu {

    public StudentManagerUI(ClickEventHandler ch) {
        super(ch, "Student");
    }

    public void onClickAddNew(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((StudentManagerUI) curr);
        createStudentUI type = new createStudentUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(type.getUI("Add Student"));
        panel.revalidate();
        panel.repaint();
    }

    public void onClickShow(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((StudentManagerUI) curr);
        listStudentUI type = new listStudentUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(type.getUI("View Students"));
        panel.revalidate();
        panel.repaint();
    }

}
