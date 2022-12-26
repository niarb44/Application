package com.company;

import javax.swing.*;
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
    JPanel testPanel = new JPanel();



    MyMouseAdapter myMouseAdapter = new MyMouseAdapter();

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
        testPanel.add(new JCheckBox("Test-1"));
        testPanel.add(new JCheckBox("Test-2"));


        this.setPreferredSize(new Dimension(110, 250));
        list1.setPreferredSize(new Dimension(110, 200));
        list2.setPreferredSize(new Dimension(110, 200));
        testPanel.setPreferredSize(new Dimension(110, 200));
        button1.setPreferredSize(new Dimension(55, 50));
        button2.setPreferredSize(new Dimension(55, 50));
        button_1.setPreferredSize(new Dimension(110, 50));
        button1.setFont(new Font("Arial", Font.PLAIN, 9));
        button2.setFont(new Font("Arial", Font.PLAIN, 9));
        button_1.setFont(new Font("Arial", Font.PLAIN, 9));

        this.setLayout(new BorderLayout());
        this.add(list1, BorderLayout.PAGE_START);
        this.add(button1, BorderLayout.LINE_START);
        this.add(button2, BorderLayout.LINE_END);

        list1.addMouseListener(myMouseAdapter);
        button_1.addMouseListener(myMouseAdapter);
    }

   public void changeAddViews(String ss){
        labels1.addElement(ss);
        this.remove(list1);
        this.add(list1, BorderLayout.PAGE_START);
        this.revalidate();
        this.repaint();
    }
    public void changeDelView(){
        int selectedIndex = list1.getSelectedIndex();
        if (selectedIndex != -1) {
            labels1.remove(selectedIndex);
        }
        this.remove(list1);
        this.add(list1, BorderLayout.PAGE_START);
        this.revalidate();
        this.repaint();
    }
    public void myFirstView(){
        this.remove(testPanel);
        this.remove(button_1);
        this.setLayout(new BorderLayout());
        this.add(list1, BorderLayout.PAGE_START);
        this.add(button1, BorderLayout.LINE_START);
        this.add(button2, BorderLayout.LINE_END);
        this.revalidate();
        this.repaint();
    }
    public void mySecondViews(){
        this.remove(list1);
        this.remove(button1);
        this.remove(button2);
        this.setLayout(new BorderLayout());
        this.add(testPanel, BorderLayout.PAGE_START);
        this.add(button_1, BorderLayout.PAGE_END);
        this.revalidate();
        this.repaint();
    }

    public class MyMouseAdapter extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount()==2 & e.getSource()==list1) {
                JList listSource = (JList) e.getSource();
                int index = listSource.locationToIndex(e.getPoint());
                if (index >= 0) {
                    Object objList = listSource.getModel().getElementAt(index);
                    System.out.println(objList.toString());
                        //    if(objList.toString().equals("TO-DO")){
                        //    }
                    mySecondViews();
                    }
            }
            if(e.getSource()==button_1){
                myFirstView();
            }
            }
    }


    public class MySaveListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            testPanel.add(new JCheckBox("Test-3"));
            PanelLeft.this.remove(0);
            PanelLeft.this.add(testPanel);
            PanelLeft.this.revalidate();
            PanelLeft.this.repaint();
            //System.out.println(labels2.getElementAt(2));

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

    }



