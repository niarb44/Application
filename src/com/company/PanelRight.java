package com.company;

import javax.swing.*;

public class PanelRight extends JPanel {

    private JButton button = new JButton("BUTTON");

    PanelRight(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(button);
    }

}
