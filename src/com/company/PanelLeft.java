package com.company;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PanelLeft extends JPanel {


    DefaultListModel<String> labels1 = new DefaultListModel<>();
    DefaultListModel<String> labels2 = new DefaultListModel<>();
    JList<String> list1 = new JList<>(labels1);
    JList<String> list2 = new JList<>(labels2);
    PanelCenter panelCenter = new PanelCenter();
    JButton button1 = new JButton("ADD");
    JButton button2 = new JButton("DEL");
    JButton button_1 = new JButton("BACK");


    MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
    MySaveListener mySaveListener = new MySaveListener();
    MyButtonListener myButtonListener = new MyButtonListener();

    PanelLeft() {
        initComponentsPanel();
    }

    public void initComponentsPanel() {
        labels1.addElement("TO-DO");
        labels1.addElement("Finance");
        labels1.addElement("Images");
        labels1.addElement("Scratchpad");
        labels2.addElement("Test-1");
        labels2.addElement("Test-2");

        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(110, 250));
        list1.setPreferredSize(new Dimension(110, 200));
        list2.setPreferredSize(new Dimension(110, 200));
        button1.setPreferredSize(new Dimension(55, 50));
        button2.setPreferredSize(new Dimension(55, 50));
        button_1.setPreferredSize(new Dimension(110, 50));
        button1.setFont(new Font("Arial", Font.PLAIN, 9));
        button2.setFont(new Font("Arial", Font.PLAIN, 9));
        button_1.setFont(new Font("Arial", Font.PLAIN, 9));

        this.add(list1, BorderLayout.PAGE_START);
        this.add(button1, BorderLayout.LINE_START);
        this.add(button2, BorderLayout.LINE_END);

        list1.addMouseListener(myMouseAdapter);
        button1.addActionListener(myButtonListener);
    }

   /* public void changeViews(JList list){
        labels2.addElement("Test-3");
        this.remove(0);
        this.add(list);
        this.revalidate();
        this.repaint();
    }*/

    public class MyMouseAdapter extends MouseAdapter{
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
                        PanelLeft.this.remove(list1);
                        PanelLeft.this.remove(button1);
                        PanelLeft.this.remove(button2);
                        PanelLeft.this.add(list2, BorderLayout.PAGE_START);
                        PanelLeft.this.add(button_1, BorderLayout.LINE_END);
                        PanelLeft.this.revalidate();
                        PanelLeft.this.repaint();
                    }
                }
            }
        }
    }

    public class MySaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            labels2.addElement("Test-3");
            PanelLeft.this.remove(0);
            PanelLeft.this.add(list2);
            PanelLeft.this.revalidate();
            PanelLeft.this.repaint();
            System.out.println(labels2.getElementAt(2));

            try{
                ObjectOutputStream outS = new ObjectOutputStream(new FileOutputStream(panelCenter.textCenter1.getText()+".txt"));
                outS.defaultWriteObject();
                outS.close();
            }
            catch(IOException error){
                System.out.println(error.getMessage());
            }


        }

    }

    public class MyButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            labels1.addElement(panelCenter.textCenter1.getText());
            PanelLeft.this.revalidate();
            PanelLeft.this.repaint();
        }
    }
}


