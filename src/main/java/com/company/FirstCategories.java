package com.company;

import javax.swing.*;

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
        this.addElement("Finance");
        this.addElement("Images");
        this.addElement("Scratchpad");

        secondCategoriesFinance.add("AddedTest");
        secondCategoriesDO.remove(1);

    }

//    public void addFirst(String name){
//        this.addElement(name);
//    }
//
//    public void deleteFirst(int element){
//        this.remove(element);
//    }
}
