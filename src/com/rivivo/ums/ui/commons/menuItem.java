package com.rivivo.ums.ui.commons;

import javax.swing.*;
import java.awt.*;

public class menuItem extends JButton {
    public menuItem(String text)
    {
        super(text);
        setBorder(null);
        setBackground(new Color(251,192,45));
        setFont(new Font("Serif", Font.BOLD,18));
        setPreferredSize(new Dimension(230,150));
    }

    public menuItem(String text, Color bg) {
        super(text);
        setBorder(null);
        setBackground(bg);
        setFont(new Font("Serif", Font.BOLD, 18));
        setPreferredSize(new Dimension(230, 150));
    }
}
