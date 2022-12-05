package com.company;

import javax.swing.*;

public class PanelLeft extends JPanel {

    private JButton button = new JButton("BUTTON");

    PanelLeft(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(button);
    }

}
