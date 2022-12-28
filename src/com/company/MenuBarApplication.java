package com.company;

import javax.swing.*;


public class MenuBarApplication extends JMenuBar {

    private JCheckBoxMenuItem onlyForRead = new JCheckBoxMenuItem("only for read");
    private JMenuItem menuItemNew = new JMenuItem("New");
    private JMenuItem menuItemSave = new JMenuItem("Save");
    private JMenuItem menuItemV1 = new JMenuItem("Version 1");
    private JMenuItem menuItemV2 = new JMenuItem("Version 2");

    PanelLeft panelLeft = new PanelLeft();
    PanelLeft.MySaveListener mySaveListener = panelLeft.new MySaveListener();

    MenuBarApplication() {
        initComponents();
    }

    public void initComponents() {

        JMenu menuFile = this.add(new JMenu("File"));
        JMenuItem subMenu = menuFile.add(menuItemNew);
        JMenuItem subMenu2 = menuFile.add(menuItemSave);
        subMenu2.addActionListener(mySaveListener);

        subMenu.addActionListener(e -> System.out.println("Here is the code that creates a new file"));

        menuFile.addSeparator();
        JMenu optionMenu = new JMenu("Options");
        menuFile.add(optionMenu);

        optionMenu.add(menuItemV1);
        optionMenu.add(menuItemV2);
        optionMenu.add(onlyForRead);

        onlyForRead.addActionListener(e -> {
            onlyForRead.setEnabled(!onlyForRead.isSelected());
        });

        JMenu helpMenu = this.add(new JMenu("Test"));

        helpMenu.add(new JMenuItem("FAQ"));

    }



}
