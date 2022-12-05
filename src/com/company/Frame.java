package com.company;

import javax.swing.*;

public class Frame extends JFrame {

    PanelUp panel = new PanelUp();

    Frame(){
        setComponentsFrame();
    }

    public void setComponentsFrame(){
        this.setTitle("Application");
        this.setBounds(400, 300, 300, 300);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.add(panel);
    }

}