package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarApplication extends JMenuBar {

    private JCheckBoxMenuItem onlyForRead = new JCheckBoxMenuItem("only for read");
    private JRadioButtonMenuItem radio;

    MenuBarApplication() {
        initComponents();
    }

    public void initComponents() {
        JMenu menuFile = this.add(new JMenu("File"));
        JMenuItem subMenu = menuFile.add(new JMenuItem("New"));

        subMenu.addActionListener(e -> System.out.println("Tu jest kod, który tworzy nowy plik"));

        menuFile.addSeparator();
        JMenu menuOpcje = new JMenu("Options");
        menuFile.add(menuOpcje);

        menuOpcje.add(new JMenuItem("Version 1"));
        menuOpcje.add(new JMenuItem("Version 2"));
        menuOpcje.add(onlyForRead);

        onlyForRead.addActionListener(e -> {
            onlyForRead.setEnabled(!onlyForRead.isSelected()); // sprawdzić czy działa
        });

        JMenu menuPomoc = this.add(new JMenu("Test"));

        menuPomoc.add(new JMenuItem("FAQ"));

    }

}
