package com.rivivo.ums.ui.program.specialization;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.modelManagerMenu;

class ClickHandler implements ClickEventHandler {
    SpecializationManagerUI dispatcher;

    public ClickHandler(SpecializationManagerUI i) {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}

public class SpecializationManagerUI extends modelManagerMenu {
    public SpecializationManagerUI(ClickEventHandler ch) {
        super(ch, "Specialization");
    }

    public void onClickAddNew(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((SpecializationManagerUI) curr);
        createSpecializationUI type = new createSpecializationUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(type.getUI("Add Specialization"));
        panel.revalidate();
        panel.repaint();
    }

    public void onClickShow(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((SpecializationManagerUI) curr);
        listSpecializationUI show = new listSpecializationUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(show.getUI("View Specialization"));
        panel.revalidate();
        panel.repaint();
    }

}
