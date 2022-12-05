package com.company;

import javax.swing.*;

public class PanelCenter extends JPanel {

    JButton button = new JButton("BUTTON");

    PanelCenter(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(button);
    }

}
