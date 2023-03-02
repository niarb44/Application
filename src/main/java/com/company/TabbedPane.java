package com.company;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

// Class with tabs, the content of the task is displayed on the second tab
public class TabbedPane extends JTabbedPane {

    private Panels panels = new Panels();
    private JPanel contentPanel = new JPanel();
    private TextArea text = new TextArea("TEXT");
    private MyMouseAdapter myMouseAdapter = new MyMouseAdapter();

    TabbedPane(){
        initComponentsPanel();
    }

    public void initComponentsPanel(){

        this.setPreferredSize(new Dimension(390, 250));
        text.setPreferredSize(new Dimension(390, 250));
        contentPanel.add(text);

        this.addTab("tab 1", panels);
        this.addTab("tab 2", contentPanel);

        for(JList x: panels.panelLeftV2.listOfSecond){
            x.addMouseListener(myMouseAdapter);
        }

    }
    public class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount()==2) {

                String content="";
                JList theList = (JList) e.getSource();
                String title = theList.getSelectedValue().toString();

                File file = new File(title+"-"+panels.panelLeftV2.whichList+".txt");
                try {
                    content = FileUtils.readFileToString(file, "UTF-8");
                } catch (IOException error) {
                    error.printStackTrace();
                }

                text.setText(content);

                TabbedPane.this.setSelectedIndex(1);
            }
        }
    }
}
