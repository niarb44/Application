package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarApplication extends JMenuBar {

    private JCheckBoxMenuItem onlyForRead = new JCheckBoxMenuItem("only for read");
    private JRadioButtonMenuItem radio;

    MenuBarApplication(){
        initComponents();
    }

    public void initComponents()
    {
        JMenu menuFile = this.add(new JMenu("File"));
        JMenuItem subMenu = menuFile.add(new JMenuItem("New"));

        subMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Tu jest kod, który tworzy nowy plik");
            }
        });

        menuFile.addSeparator();
        final JMenuItem podMenuZapisz = menuFile.add(new JMenuItem("Save"));
        menuFile.add(new JMenuItem("Load"));
        menuFile.addSeparator();
        JMenu menuOpcje = new JMenu("Options");
        menuFile.add(menuOpcje);

        menuOpcje.add(new JMenuItem("Option 1"));
        menuOpcje.add(new JMenuItem("Option 2"));
        menuOpcje.add(onlyForRead);

        onlyForRead.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e)
            {
                if (onlyForRead.isSelected())
                    onlyForRead.setEnabled(false);
                else
                    onlyForRead.setEnabled(true);
            }
        });

        JMenu menuPomoc = this.add(new JMenu("Help"));

        menuPomoc.add(new JMenuItem("FAQ"));

    }

}
