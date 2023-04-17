package com.company;

import javax.swing.*;

/**
 * Bar with a drop-down menu.
 */
public class MenuBarApplication extends JMenuBar {

    private final JCheckBoxMenuItem onlyForRead = new JCheckBoxMenuItem("only for read");
    private final JMenuItem menuItemNew = new JMenuItem("New");
    private final JMenuItem menuItemV1 = new JMenuItem("Version 1");
    private final JMenuItem menuItemV2 = new JMenuItem("Version 2");

    MenuBarApplication() {
        initComponents();
    }

    public void initComponents() {

        JMenu menuFile = this.add(new JMenu("File"));
        JMenuItem subMenu = menuFile.add(menuItemNew);

        subMenu.addActionListener(e -> System.out.println("Here is the code that creates a new file"));

        menuFile.addSeparator();
        JMenu optionMenu = new JMenu("Options");
        menuFile.add(optionMenu);

        optionMenu.add(menuItemV1);
        optionMenu.add(menuItemV2);
        optionMenu.add(onlyForRead);

        onlyForRead.addActionListener(e -> onlyForRead.setEnabled(!onlyForRead.isSelected()));

        JMenu helpMenu = this.add(new JMenu("Help"));

        helpMenu.add(new JMenuItem("FAQ"));

    }
}
