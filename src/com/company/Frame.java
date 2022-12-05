package com.company;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    PanelUp panelUp = new PanelUp();
    PanelDown panelDown = new PanelDown();
    PanelRight panelRight = new PanelRight();
    PanelLeft panelLeft = new PanelLeft();
    PanelCenter panelCenter = new PanelCenter();

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
        this.setBounds(400, 300, 300, 300);
        this.pack();
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}