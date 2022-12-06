package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelCenter extends JPanel {

    private TextField textCenter = new TextField("test text");

    PanelCenter(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textCenter);
    }

}
