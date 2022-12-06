package com.company;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private PanelUp panelUp = new PanelUp();
    private PanelDown panelDown = new PanelDown();
    private PanelRight panelRight = new PanelRight();
    private PanelLeft panelLeft = new PanelLeft();
    private PanelCenter panelCenter = new PanelCenter();
    private MenuBarApplication menuBarApplication = new MenuBarApplication();

    Frame(){
        setComponentsFrame();
    }

    public void setComponentsFrame(){
        this.getContentPane().add(panelUp, BorderLayout.PAGE_START);
        this.getContentPane().add(panelDown, BorderLayout.PAGE_END);
        this.getContentPane().add(panelRight, BorderLayout.LINE_START);
        this.getContentPane().add(panelLeft, BorderLayout.LINE_END);
        this.getContentPane().add(panelCenter, BorderLayout.CENTER);

        this.setTitle("Application");
        this.setBounds(0, 150, 300, 300);
        this.setJMenuBar(menuBarApplication);
        this.pack();
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}