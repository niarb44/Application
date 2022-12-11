package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelLeft extends JPanel {


    String[] labels = {"TO-DO", "Finance", "Images", "Scratchpad"};
    String[] labels2 = {"A", "B", "C", "D"};
    JList list = new JList(labels);
    JList list2 = new JList(labels2);
    MyMouseAdapter myMouseAdapter = new MyMouseAdapter();

    PanelLeft() {
        initComponentsPanel();
    }

    public void initComponentsPanel() {

        this.setPreferredSize(new Dimension(110, 250));
        list.setPreferredSize(new Dimension(110, 250));
        list2.setPreferredSize(new Dimension(110, 250));

        this.add(list);

        list.addMouseListener(myMouseAdapter);

    }

    class MyMouseAdapter extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            JList listSource = (JList) e.getSource();
            if(e.getClickCount()==2){
                int index = listSource.locationToIndex(e.getPoint());
                if(index>=0){
                    Object objList = listSource.getModel().getElementAt(index);
                    System.out.println(objList.toString());
                    if(objList.toString().equals("TO-DO")){
                        System.out.println("!!!!!!!!!!!!!!!!!!!!");
                        PanelLeft.this.remove(list);
                        PanelLeft.this.add(list2);
                        PanelLeft.this.revalidate();
                        PanelLeft.this.repaint();
                    }
                }
            }
        }
    }

}


