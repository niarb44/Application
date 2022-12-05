package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUp extends JPanel {

    private JButton button = new JButton("BUTTON");
    private JMenuBar menuBar = new JMenuBar();

    PanelUp(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(button);
    }


}
