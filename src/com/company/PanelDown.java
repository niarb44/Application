package com.company;

import javax.swing.*;

public class PanelDown extends JPanel {

    private JButton button = new JButton("BUTTON");

    PanelDown(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(button);
    }

}
