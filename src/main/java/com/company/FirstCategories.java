package com.company;

import javax.swing.*;

// Class with main categories
public class FirstCategories extends DefaultListModel<String> {

    SecondCategories secondCategoriesDO = new SecondCategories();
    SecondCategories secondCategoriesFinance = new SecondCategories();
    SecondCategories secondCategoriesImages = new SecondCategories();
    SecondCategories secondCategoriesScratchpad = new SecondCategories();

    public FirstCategories() {
        initComponents();
    }

    public void initComponents(){
        this.addElement("TO-DO");
        this.addElement("FINANCE");
        this.addElement("SHOPPING");
        this.addElement("SCRATCHPAD");
    }
}

