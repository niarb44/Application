package com.company;

import javax.swing.*;

public class SecondCategories extends DefaultListModel<String> {

    public SecondCategories() {
        initComponents();
    }

    public void initComponents(){
        this.addElement("Test-1");
        this.addElement("Test-2");
    }

    public void add(String name){
        this.addElement(name);
    }

    public void delete(int element){
        this.remove(element);
    }


}
