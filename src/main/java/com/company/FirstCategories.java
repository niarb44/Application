package com.company;

import javax.swing.*;

/**
 * Class with main categories.
 */
public class FirstCategories extends DefaultListModel<String> {

    Subcategories secondCategoriesDO = new Subcategories();
    Subcategories secondCategoriesFinance = new Subcategories();
    Subcategories secondCategoriesImages = new Subcategories();
    Subcategories secondCategoriesOther = new Subcategories();

    public FirstCategories() {
        initComponents();
    }

    public void initComponents(){
        this.addElement("TO-DO");
        this.addElement("FINANCE");
        this.addElement("SHOPPING");
        this.addElement("OTHER");
    }
}

