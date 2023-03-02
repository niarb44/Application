package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panels extends JPanel {

    private PanelLeft panelLeft = new PanelLeft();
    private PanelCenter panelCenter = new PanelCenter();
    MyListener myListener = new MyListener();

    Panels() {
        setComponentsPanels();
    }

    public void setComponentsPanels() {

        this.setPreferredSize(new Dimension(310, 250));

        this.add(panelLeft);
        this.add(panelCenter);

        panelLeft.buttonAdd2.addActionListener(myListener);
        panelLeft.buttonDel22.addActionListener(myListener);



    }

    public class MyListener implements ActionListener {
        String title = "";
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==panelLeft.buttonAdd2) {
                title = panelCenter.textCenter1.getText();
                panelLeft.changeAddViews2(title);
            }
            if(e.getSource()==panelLeft.buttonDel22) {
                panelLeft.changeDelView2();
            }

        }

    }
}
