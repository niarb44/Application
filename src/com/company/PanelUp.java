package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUp extends JPanel {

    private TextArea textUp = new TextArea("test text");
    private JMenuBar menuBar = new JMenuBar();

    PanelUp(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textUp);
    }


}
