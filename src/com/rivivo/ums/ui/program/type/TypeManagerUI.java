package com.rivivo.ums.ui.program.type;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.modelManagerMenu;

class ClickHandler implements ClickEventHandler {
    TypeManagerUI dispatcher;

    public ClickHandler(TypeManagerUI i) {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}

public class TypeManagerUI extends modelManagerMenu {
    public TypeManagerUI(ClickEventHandler ch) {
        super(ch, "Type");
    }

    public void onClickAddNew(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((TypeManagerUI) curr);
        createTypeUI type = new createTypeUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(type.getUI("Add Type"));
        panel.revalidate();
        panel.repaint();
    }

    public void onClickShow(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((TypeManagerUI) curr);
        listTypeUI show = new listTypeUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(show.getUI("View Types"));
        panel.revalidate();
        panel.repaint();
    }

}
