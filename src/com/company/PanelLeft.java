package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelLeft extends JPanel {

    private JCheckBox textLeft = new JCheckBox("test");

    PanelLeft(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.setPreferredSize(new Dimension(50, 250));
        textLeft.setPreferredSize(new Dimension(50, 250));

        this.add(textLeft);
    }

}
