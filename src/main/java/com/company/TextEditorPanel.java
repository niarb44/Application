package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Center of frame(in second view) - with space to enter title and contents of task.
 */
public class TextEditorPanel extends JPanel {

    JTextField textCenter1 = new JTextField("Title");
    JTextField textCenter2 = new JTextField("Contents");

    TextEditorPanel(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){
        this.setPreferredSize(new Dimension(280, 250));
        textCenter1.setPreferredSize(new Dimension(280, 50));
        textCenter2.setPreferredSize(new Dimension(280, 200));

        this.setLayout(new BorderLayout());
        this.add(textCenter1, BorderLayout.PAGE_START);
        this.add(textCenter2, BorderLayout.PAGE_END);
    }
}