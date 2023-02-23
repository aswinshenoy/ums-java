package com.rivivo.ums.ui.campus;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.modelManagerMenu;

class ClickHandler implements ClickEventHandler {
    CampusManagerUI dispatcher;

    public ClickHandler(CampusManagerUI i)
    {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}

public class CampusManagerUI extends modelManagerMenu {
    public CampusManagerUI(ClickEventHandler ch) {
        super(ch, "Campus");
    }

    public void onClickAddNew(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((CampusManagerUI) curr);
        createCampusUI campusForm = new createCampusUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(campusForm.getUI("Add Campus"));
        panel.revalidate();
        panel.repaint();
    }

    public void onClickShow(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((CampusManagerUI) curr);
        listCampusUI type = new listCampusUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(type.getUI("Campus List"));
        panel.revalidate();
        panel.repaint();
    }

}
