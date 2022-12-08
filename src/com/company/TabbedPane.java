package com.company;

import javax.swing.*;
import java.awt.*;

public class TabbedPane extends JTabbedPane {

    private Panels panels = new Panels();
    private Panels panels2;

    private JPanel panel1 = new JPanel();
    private TextArea text = new TextArea("TEXT");

    TabbedPane(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){

        this.setPreferredSize(new Dimension(250, 250));
        panel1.add(text);

        this.addTab("tab 1", panels);
        //this.setMnemonicAt(0, KeyEvent.VK_1);
        panels2 = new Panels();
        this.addTab("tab 2", panel1);

    }


}
