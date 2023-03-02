package com.company;

import javax.swing.*;
import java.awt.*;

// Aplication frame
public class Frame extends JFrame {

    private MenuBarApplication menuBarApplication = new MenuBarApplication();
    private TabbedPane tabbedPane = new TabbedPane();

    Frame(){
        setComponentsFrame();
    }

    public void setComponentsFrame(){

        this.setTitle("TO-DO APPLICATION");
        this.setLocation(400, 250);
        this.setPreferredSize(new Dimension(430, 350));

        this.setJMenuBar(menuBarApplication);
        this.getContentPane().add(tabbedPane);

        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}