package com.company;

import javax.swing.*;

public class TabbedPane extends JTabbedPane {

    private Panels panels = new Panels();
    private Panels panels2;

    TabbedPane(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){

        this.addTab("tab 1", panels);
        //this.setMnemonicAt(0, KeyEvent.VK_1);
        panels2 = new Panels();
        this.addTab("tab 2", panels2);

    }


}
