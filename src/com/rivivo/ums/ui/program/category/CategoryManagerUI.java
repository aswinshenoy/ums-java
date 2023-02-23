package com.rivivo.ums.ui.program.category;

import com.rivivo.ums.ui.commons.ClickEventHandler;
import com.rivivo.ums.ui.commons.modelManagerMenu;

class ClickHandler implements ClickEventHandler {
    CategoryManagerUI dispatcher;

    public ClickHandler(CategoryManagerUI i) {
        dispatcher = i;
    }

    public void handleClick() {
        dispatcher.reset();
    }
}

public class CategoryManagerUI extends modelManagerMenu {
    public CategoryManagerUI(ClickEventHandler ch) {
        super(ch, "Specialization");
    }

    public void onClickAddNew(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((CategoryManagerUI) curr);
        createCategoryUI type = new createCategoryUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(type.getUI("Add Category"));
        panel.revalidate();
        panel.repaint();
    }

    public void onClickShow(modelManagerMenu curr) {
        ClickHandler ch = new ClickHandler((CategoryManagerUI) curr);
        listCategoriesUI show = new listCategoriesUI(ch);
        menu.setVisible(false);
        panel.removeAll();
        panel.add(show.getUI("View Categories"));
        panel.revalidate();
        panel.repaint();
    }
}