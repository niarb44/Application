package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelRight extends JPanel {

    private TextField textRight = new TextField("test text");

    PanelRight(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textRight);
    }

}
