package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelDown extends JPanel{

    private TextField textDown = new TextField("test text");

    PanelDown(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textDown);
    }

}
