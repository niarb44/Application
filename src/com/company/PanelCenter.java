package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelCenter extends JPanel {

    private TextArea textCenter = new TextArea("test text");

    PanelCenter(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.add(textCenter);
    }

}
