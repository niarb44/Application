package com.company;

import javax.swing.*;

public class Frame extends JFrame {

    private MenuBarApplication menuBarApplication = new MenuBarApplication();
    private TabbedPane tabbedPane = new TabbedPane();

    Frame(){
        setComponentsFrame();
    }

    public void setComponentsFrame(){

        this.setTitle("Application");
        this.setBounds(0, 150, 300, 300);

        this.setJMenuBar(menuBarApplication);
        this.getContentPane().add(tabbedPane);

        this.pack();
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

}