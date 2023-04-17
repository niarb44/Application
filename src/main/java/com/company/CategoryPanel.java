package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Left side of frame(in first view) - with categories of tasks.
 */
public class CategoryPanel extends JPanel {

    JList<String> list1;
    JButton buttonChoose = new JButton("CHOOSE-IT");
    private final FirstCategories firstCategories = new FirstCategories();

    CategoryPanel() {
        initComponentsPanel();
    }

    public void initComponentsPanel() {

        list1 = new JList<>(firstCategories);

        this.setPreferredSize(new Dimension(110, 250));
        list1.setPreferredSize(new Dimension(110, 200));
        buttonChoose.setPreferredSize(new Dimension(110, 50));
        buttonChoose.setFont(new Font("Arial", Font.PLAIN, 9));
        list1.setFont(new Font("Arial", Font.BOLD, 13));

        this.setLayout(new BorderLayout());
        this.add(list1, BorderLayout.PAGE_START);
        this.add(buttonChoose, BorderLayout.PAGE_END);

    }

    }



