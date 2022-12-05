package com.company;

import javax.swing.*;

public class PanelRight extends JPanel {

    JButton button = new JButton("BUTTON");

    PanelRight(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(button);
    }

}
