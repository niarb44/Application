package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelLeft extends JPanel {

    private TextArea textLeft = new TextArea("test text left");

    PanelLeft(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textLeft);
    }

}
