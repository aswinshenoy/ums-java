package com.rivivo.ums.ui.program.program;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.modelManagerMenu;

class ClickHandler implements ClickEventHandler {
    programManUI dispatcher;

    public ClickHandler(programManUI i) {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}

public class programManUI extends modelManagerMenu {
    public programManUI(ClickEventHandler ch) {
        super(ch, "Program");
    }

    public void onClickAddNew(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((programManUI) curr);
        createProgramUI type = new createProgramUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(type.getUI("Add Programs"));
        panel.revalidate();
        panel.repaint();
    }

    public void onClickShow(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((programManUI) curr);
        listProgramUI show = new listProgramUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(show.getUI("View Programs"));
        panel.revalidate();
        panel.repaint();
    }

}
