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
import java.util.ArrayList;

public class PanelLeft extends JPanel {


    DefaultListModel<String> labels1 = new DefaultListModel<>();
    DefaultListModel<String> labels2 = new DefaultListModel<>();
    JList<String> list1 = new JList<>(labels1);
    JList<String> list2 = new JList<>(labels2);
    ArrayList<Integer> elementsToColor = new ArrayList<Integer>();
    ArrayList<Integer> elementsToColorTemporary = new ArrayList<Integer>();
    com.company.PanelCenter panelCenter = new com.company.PanelCenter();
    JButton buttonAdd = new JButton("ADD");
    JButton buttonDel = new JButton("DEL");
    JButton buttonAdd2 = new JButton("ADD");
    JPopupMenu buttonDel2 = new JPopupMenu("del");
    JButton buttonDel22 = new JButton("DEL");
    JButton buttonBack = new JButton("BACK");
    JPanel testPanel = new JPanel();
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
    JCheckBox checkBox1 = new JCheckBox("Task-1");
    JCheckBox checkBox2 = new JCheckBox("Task-2");
    int indexChangesColor = 0;
    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem jmi1, jmi2;
    JPanel borderPanel = new JPanel();
    JPanel boxPanel = new JPanel();

    PanelLeft() {
        initComponentsPanel();
    }

    public void initComponentsPanel() {

        popupMenu.add(jmi1= new JMenuItem("Done"));
        popupMenu.add(new JPopupMenu.Separator());
        popupMenu.add(jmi2 = new JMenuItem("Not-Done"));

        //buttonDel2.add(cut); buttonDel2.add(copy); buttonDel2.add(paste);
        testPanel.setComponentPopupMenu(buttonDel2);
        labels1.addElement("TO-DO");
        labels1.addElement("Finance");
        labels1.addElement("Images");
        labels1.addElement("Scratchpad");
        labels2.addElement("Test-1");
        labels2.addElement("Test-2");
//        testPanel.add(new JCheckBox("Task-1"));
//        testPanel.add(new JCheckBox("Task-2"));
        testPanel.add(checkBox1);
        testPanel.add(checkBox2);


        this.setPreferredSize(new Dimension(110, 250));
        list1.setPreferredSize(new Dimension(110, 200));
        list2.setPreferredSize(new Dimension(110, 200));
        testPanel.setPreferredSize(new Dimension(110, 150));
        buttonAdd.setPreferredSize(new Dimension(55, 50));
        buttonDel.setPreferredSize(new Dimension(55, 50));
        buttonBack.setPreferredSize(new Dimension(110, 25));
        buttonAdd.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonDel.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonAdd2.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonDel22.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonBack.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonAdd2.setPreferredSize(new Dimension(55, 25));
        buttonDel2.setPreferredSize(new Dimension(55, 50));
        buttonDel22.setPreferredSize(new Dimension(55, 25));

        this.setLayout(new BorderLayout());
        this.add(list1, BorderLayout.PAGE_START);
        this.add(buttonAdd, BorderLayout.LINE_START);
        this.add(buttonDel, BorderLayout.LINE_END);

        list1.addMouseListener(myMouseAdapter);
        buttonBack.addMouseListener(myMouseAdapter);
        list2.setCellRenderer(new MyListCellRenderer());

        list2.addMouseListener(new MouseAdapter() {
                                  public void mouseClicked(MouseEvent me) {
                                      if (SwingUtilities.isRightMouseButton(me)) {
                                          popupMenu.show(list2, me.getX(), me.getY());
                                          JList theList = (JList) me.getSource();
                                          indexChangesColor = theList.locationToIndex(me.getPoint());
                                      }
                                  }
                              }
        );

        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementsToColor.add(indexChangesColor);
                list2.setCellRenderer(new MyListCellRenderer());
            }
        });
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementsToColor.remove(Integer.valueOf(indexChangesColor));
                list2.setCellRenderer(new MyListCellRenderer());
            }
        });

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
    public void changeAddViews2(String ss){
        labels2.addElement(ss);
        this.remove(boxPanel);
        this.add(boxPanel);
        this.remove(borderPanel);
        this.add(borderPanel);
        this.revalidate();
        this.repaint();
    }

//    public void changeDelView2(){
//        testPanel.remove(checkBox1);
//        mySecondViews();
//    }
    public void changeDelView2(){
        Integer selectedIndex = list2.getSelectedIndex();
        System.out.println(elementsToColor);
        elementsToColorTemporary.clear();
        for(int x : elementsToColor){
            elementsToColorTemporary.add(x);
        }
        System.out.println(elementsToColor);
        System.out.println(elementsToColorTemporary);

        for(int y : elementsToColor){
            if(selectedIndex < y){
                elementsToColorTemporary.remove(Integer.valueOf(y));
                elementsToColorTemporary.add(y-1);
            }
            else if(selectedIndex.equals(y)){
                elementsToColorTemporary.remove(Integer.valueOf(y));
            }
        }
        System.out.println(elementsToColor);
        System.out.println(elementsToColorTemporary);
        elementsToColor.clear();
        for(int z : elementsToColorTemporary){
            elementsToColor.add(z);
        }
        System.out.println(elementsToColor);


        if (selectedIndex != -1) {
            labels2.remove(selectedIndex);
        }
        System.out.println(elementsToColor);
        this.remove(boxPanel);
        System.out.println(elementsToColor);
        this.remove(borderPanel);
        System.out.println(elementsToColor);
        this.add(boxPanel);
        System.out.println(elementsToColor);
        this.add(borderPanel);
        System.out.println(elementsToColor);
        this.revalidate();
        System.out.println(elementsToColor);
        this.repaint();
        System.out.println(elementsToColor);
    }
    public void myFirstView(){
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(list1, BorderLayout.PAGE_START);
        this.add(buttonAdd, BorderLayout.LINE_START);
        this.add(buttonDel, BorderLayout.LINE_END);
        this.revalidate();
        this.repaint();
    }
    public void mySecondViews(){
        this.removeAll();
        borderPanel.setLayout(new BorderLayout());
        borderPanel.setPreferredSize(new Dimension(110, 50));
        borderPanel.add(buttonAdd2, BorderLayout.LINE_START);
        borderPanel.add(buttonDel22, BorderLayout.LINE_END);
        borderPanel.add(buttonBack, BorderLayout.PAGE_END);
//        this.setLayout(new BorderLayout());
////        this.add(testPanel, BorderLayout.PAGE_START);
//        this.add(list2, BorderLayout.PAGE_START);
//        this.add(borderPanel, BorderLayout.PAGE_END);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //boxPanel.setPreferredSize(new Dimension(110, 200));
        boxPanel.add(list2);
        this.add(boxPanel);
        this.add(borderPanel);
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
                    mySecondViews();
                    }
            }
            if(e.getSource()==buttonBack){
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

    public class MyListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            renderer.setBackground(Color.RED);
            for(int x : elementsToColor){
                if(index == x){
                    renderer.setBackground(Color.GREEN);
                }
            }
            return renderer;
        }
    }


    }



