package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelLeft extends JPanel {

    private TextField textLeft = new TextField("test text");

    PanelLeft(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textLeft);
    }

}
