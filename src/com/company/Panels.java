package com.company;

import javax.swing.*;
import java.awt.*;

public class Panels extends JPanel {

    //private PanelRight panelRight = new PanelRight();
    private PanelLeft panelLeft = new PanelLeft();
    private PanelCenter panelCenter = new PanelCenter();

    Panels(){
        setComponentsPanels();
    }

    public void setComponentsPanels(){

        this.setPreferredSize(new Dimension(250, 250));

       // this.setLayout(new BorderLayout());
        this.add(panelLeft/*, BorderLayout.LINE_START*/);
        this.add(panelCenter/*, BorderLayout.CENTER*/);
        //this.add(panelRight, BorderLayout.LINE_END);

    }

}
