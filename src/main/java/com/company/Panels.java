package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// class to manage frame content
public class Panels extends JPanel {

    PanelLeft panelLeft = new PanelLeft();
    PanelLeftV2 panelLeftV2 = new PanelLeftV2();
    PanelCenter panelCenter = new PanelCenter();
    PanelCenterV2 panelCenterV2 = new PanelCenterV2();
    MyListener myListener = new MyListener();
    MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
    NoteFiles noteFiles;

    Panels() {
        setComponentsPanels();
    }

    public void setComponentsPanels() {

        panelLeft.list1.addMouseListener(myMouseAdapter);
        panelLeftV2.buttonBack.addMouseListener(myMouseAdapter);
        panelLeft.buttonChoose.addMouseListener(myMouseAdapter);

        this.setPreferredSize(new Dimension(310, 250));

        this.add(panelLeft);
        this.add(panelCenter);

        panelLeftV2.buttonAdd2.addActionListener(myListener);
        panelLeftV2.buttonDel22.addActionListener(myListener);



    }

    public class MyListener implements ActionListener {
        String title = "";
        String title2 = "";
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==panelLeftV2.buttonAdd2) {
                noteFiles = new NoteFiles();
                title = panelCenterV2.textCenter1.getText();
                title2 = panelCenterV2.textCenter2.getText();
                noteFiles.noteFilesExecute2(title, title2, panelLeftV2.whichList);
                if (!noteFiles.isFileExists) {
                    panelLeftV2.changeAddViews2(title);
                }
            }

            if(e.getSource()==panelLeftV2.buttonDel22) {
                panelLeftV2.changeDelView2();
            }

        }

    }
    public class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount()==2 & e.getSource()==panelLeft.list1) {
                JList listSource = (JList) e.getSource();
                int index = listSource.locationToIndex(e.getPoint());
                if (index >= 0) {
                    Object objList = listSource.getModel().getElementAt(index);
                    if(objList.toString().equals("TO-DO")){
                        panelLeftV2.whichList = 1;
                        panelLeftV2.boxPanel.removeAll();
                        panelLeftV2.boxPanel.add(panelLeftV2.list2DO);
                    }
                    else if(objList.toString().equals("FINANCE")){
                        panelLeftV2.whichList = 2;
                        panelLeftV2.boxPanel.removeAll();
                        panelLeftV2.boxPanel.add(panelLeftV2.list2Finance);
                    }
                    else if(objList.toString().equals("SHOPPING")){
                        panelLeftV2.whichList = 3;
                        panelLeftV2.boxPanel.removeAll();
                        panelLeftV2.boxPanel.add(panelLeftV2.list2Images);
                    }
                    else if(objList.toString().equals("SCRATCHPAD")){
                        panelLeftV2.whichList = 4;
                        panelLeftV2.boxPanel.removeAll();
                        panelLeftV2.boxPanel.add(panelLeftV2.list2Scratchpad);
                    }
                    Panels.this.remove(panelLeft);
                    Panels.this.remove(panelCenter);
                    Panels.this.add(panelLeftV2);
                    Panels.this.add(panelCenterV2);
                    Panels.this.revalidate();
                    Panels.this.repaint();
                }
            }
            if(e.getSource()==panelLeftV2.buttonBack){
                Panels.this.remove(panelLeftV2);
                Panels.this.remove(panelCenterV2);
                Panels.this.add(panelLeft);
                Panels.this.add(panelCenter);
                Panels.this.revalidate();
                Panels.this.repaint();
            }


            if(e.getSource()==panelLeft.buttonChoose){

                int index = panelLeft.list1.getSelectedIndex();

                if(index==0){
                    panelLeftV2.whichList = 1;
                    panelLeftV2.boxPanel.removeAll();
                    panelLeftV2.boxPanel.add(panelLeftV2.list2DO);
                }
                else if(index==1){
                    panelLeftV2.whichList = 2;
                    panelLeftV2.boxPanel.removeAll();
                    panelLeftV2.boxPanel.add(panelLeftV2.list2Finance);
                }
                else if(index==2){
                    panelLeftV2.whichList = 3;
                    panelLeftV2.boxPanel.removeAll();
                    panelLeftV2.boxPanel.add(panelLeftV2.list2Images);
                }
                else if(index==3){
                    panelLeftV2.whichList = 4;
                    panelLeftV2.boxPanel.removeAll();
                    panelLeftV2.boxPanel.add(panelLeftV2.list2Scratchpad);
                }

                Panels.this.remove(panelLeft);
                Panels.this.remove(panelCenter);
                Panels.this.add(panelLeftV2);
                Panels.this.add(panelCenterV2);
                Panels.this.revalidate();
                Panels.this.repaint();
            }
        }
    }

}
