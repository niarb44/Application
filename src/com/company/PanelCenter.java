package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelCenter extends JPanel {

    private TextArea textCenter = new TextArea("test");

    PanelCenter(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.setPreferredSize(new Dimension(200, 250));
        textCenter.setPreferredSize(new Dimension(200, 250));
        this.add(textCenter);
    }

}
