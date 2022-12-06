package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelDown extends JPanel {

    private TextArea textDown = new TextArea("test text");

    PanelDown(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textDown);
    }

}
