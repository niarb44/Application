package com.company;

import javax.swing.*;
import java.awt.*;

public class TabbedPane extends JTabbedPane {

    private Panels panels = new Panels();

    private JPanel contentPanel = new JPanel();
    private TextArea text = new TextArea("TEXT");

    TabbedPane(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){

        this.setPreferredSize(new Dimension(390, 250));
        text.setPreferredSize(new Dimension(390, 250));
        contentPanel.add(text);

        this.addTab("tab 1", panels);
        this.addTab("tab 2", contentPanel);

    }


}
