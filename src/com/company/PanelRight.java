package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelRight extends JPanel {

    private TextArea textRight = new TextArea("test text");

    PanelRight(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textRight);
    }

}
