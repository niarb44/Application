package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelCenterV2 extends JPanel {

    protected JTextField textCenter1 = new JTextField("Title");
    public JTextField textCenter2 = new JTextField("Contents");


    PanelCenterV2(){
        initComponentsPanel();
    }


    public void initComponentsPanel(){
        this.setPreferredSize(new Dimension(280, 250));
        textCenter1.setPreferredSize(new Dimension(280, 50));
        textCenter2.setPreferredSize(new Dimension(280, 200));

        this.setLayout(new BorderLayout());
        this.add(textCenter1, BorderLayout.PAGE_START);
        this.add(textCenter2, BorderLayout.PAGE_END);
    }
}