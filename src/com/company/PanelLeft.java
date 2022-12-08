package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelLeft extends JPanel {

    private JCheckBox optionLeft1, optionLeft2, optionLeft3, optionLeft4;

    PanelLeft(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        optionLeft1 = new JCheckBox("TO-DO");
        optionLeft2 = new JCheckBox("Finance");
        optionLeft3 = new JCheckBox("Images");
        optionLeft4 = new JCheckBox("scratchpad");

        this.setPreferredSize(new Dimension(110, 250));
      //  textLeft.setPreferredSize(new Dimension(50, 250));

        this.add(optionLeft1);
        this.add(optionLeft2);
        this.add(optionLeft3);
        this.add(optionLeft4);
    }

}
