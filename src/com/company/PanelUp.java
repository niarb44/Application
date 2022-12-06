package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUp extends JPanel {

    private TextField textUp = new TextField("test text");
    private JMenuBar menuBar = new JMenuBar();

    PanelUp(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textUp);
    }


}
