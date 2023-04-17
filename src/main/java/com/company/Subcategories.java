package com.company;

import javax.swing.*;

/**
 * Class with tasks in each category.
 */
public class Subcategories extends DefaultListModel<String> {

    public Subcategories() {
        initComponents();
    }

    public void initComponents(){
        this.addElement("Test-1");
        this.addElement("Test-2");
    }




}
