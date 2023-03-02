package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PanelLeft extends JPanel {

    JList<String> list1;
    JButton buttonChoose = new JButton("CHOOSE-IT");
    JPanel testPanel = new JPanel();
    JCheckBox checkBox1 = new JCheckBox("Task-1");
    JCheckBox checkBox2 = new JCheckBox("Task-2");
    FirstCategories firstCategories = new FirstCategories();

    PanelLeft() {
        initComponentsPanel();
    }

    public void initComponentsPanel() {

        list1 = new JList<>(firstCategories);


//        testPanel.add(new JCheckBox("Task-1"));
//        testPanel.add(new JCheckBox("Task-2"));
        testPanel.add(checkBox1);
        testPanel.add(checkBox2);


        this.setPreferredSize(new Dimension(110, 250));
        list1.setPreferredSize(new Dimension(110, 200));
        testPanel.setPreferredSize(new Dimension(110, 150));
        buttonChoose.setPreferredSize(new Dimension(110, 50));
        buttonChoose.setFont(new Font("Arial", Font.PLAIN, 9));
        list1.setFont(new Font("Arial", Font.BOLD, 13));

        this.setLayout(new BorderLayout());
        this.add(list1, BorderLayout.PAGE_START);
        this.add(buttonChoose, BorderLayout.PAGE_END);

    }


    public void myFirstView(){
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(list1, BorderLayout.PAGE_START);
        this.add(buttonChoose, BorderLayout.PAGE_END);
        this.revalidate();
        this.repaint();
    }



    public class MySaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            testPanel.add(new JCheckBox("Test-3"));
            PanelLeft.this.remove(0);
            PanelLeft.this.add(testPanel);
            PanelLeft.this.revalidate();
            PanelLeft.this.repaint();
        }
    }

    }



