package com.company;

import javax.swing.*;
import java.awt.*;

public class PanelCenter extends JPanel {

    protected JTextField textCenter1 = new JTextField("Tytuł");
    private JTextField textCenter2 = new JTextField("test");

    PanelCenter(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.setPreferredSize(new Dimension(280, 250));
        textCenter1.setPreferredSize(new Dimension(300, 50));
        textCenter2.setPreferredSize(new Dimension(300, 300));

        this.setLayout(new SpringLayout());
        this.add(textCenter1);
        this.add(textCenter2);
    }

}
