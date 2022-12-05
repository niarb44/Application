package com.company;

import javax.swing.*;

public class PanelUp extends JPanel {

    JButton button = new JButton("BUTTON");

    PanelUp(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(button);
    }

}
