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

    JList<String> list1;
    JList<String> list2DO;
    JList<String> list2Finance;
    JList<String> list2Images;
    JList<String> list2Scratchpad;
    ArrayList<Integer> elementsToColor = new ArrayList<Integer>();
    ArrayList<Integer> elementsToColorTemporary = new ArrayList<Integer>();
    PanelCenter panelCenter = new PanelCenter();
    JButton buttonChoose = new JButton("CHOOSE-IT");
    JButton buttonAdd2 = new JButton("ADD");
    JButton buttonDel22 = new JButton("DEL");
    JButton buttonBack = new JButton("BACK");
    JPanel testPanel = new JPanel();
    MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
    JCheckBox checkBox1 = new JCheckBox("Task-1");
    JCheckBox checkBox2 = new JCheckBox("Task-2");
    int indexChangesColor = 0;
    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem jmi1, jmi2;
    JPanel borderPanel = new JPanel();
    JPanel boxPanel = new JPanel();
    FirstCategories firstCategories = new FirstCategories();
    int whichList = 0;

    PanelLeft() {
        initComponentsPanel();
    }

    public void initComponentsPanel() {

        list1 = new JList<>(firstCategories);
        list2DO = new JList<>(firstCategories.secondCategoriesDO);
        list2Finance = new JList<>(firstCategories.secondCategoriesFinance);
        list2Images = new JList<>(firstCategories.secondCategoriesImages);
        list2Scratchpad = new JList<>(firstCategories.secondCategoriesScratchpad);

        popupMenu.add(jmi1= new JMenuItem("Done"));
        popupMenu.add(new JPopupMenu.Separator());
        popupMenu.add(jmi2 = new JMenuItem("Not-Done"));

//        testPanel.add(new JCheckBox("Task-1"));
//        testPanel.add(new JCheckBox("Task-2"));
        testPanel.add(checkBox1);
        testPanel.add(checkBox2);


        this.setPreferredSize(new Dimension(110, 250));
        list1.setPreferredSize(new Dimension(110, 200));
        list2Finance.setPreferredSize(new Dimension(110, 200));
        list2DO.setPreferredSize(new Dimension(110, 200));
        list2Images.setPreferredSize(new Dimension(110, 200));
        list2Scratchpad.setPreferredSize(new Dimension(110, 200));
        testPanel.setPreferredSize(new Dimension(110, 150));
        buttonChoose.setPreferredSize(new Dimension(110, 50));
        buttonBack.setPreferredSize(new Dimension(110, 25));
        buttonChoose.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonAdd2.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonDel22.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonBack.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonAdd2.setPreferredSize(new Dimension(55, 25));
        buttonDel22.setPreferredSize(new Dimension(55, 25));

        this.setLayout(new BorderLayout());
        this.add(list1, BorderLayout.PAGE_START);
        this.add(buttonChoose, BorderLayout.PAGE_END);

        list1.addMouseListener(myMouseAdapter);
        buttonBack.addMouseListener(myMouseAdapter);
        buttonChoose.addMouseListener(myMouseAdapter);

        list2DO.setCellRenderer(new MyListCellRenderer());
        list2Finance.setCellRenderer(new MyListCellRenderer());
        list2Images.setCellRenderer(new MyListCellRenderer());
        list2Scratchpad.setCellRenderer(new MyListCellRenderer());

        list2DO.addMouseListener(new MouseAdapter() {
                                  public void mouseClicked(MouseEvent me) {
                                      if (SwingUtilities.isRightMouseButton(me)) {
                                          popupMenu.show(list2DO, me.getX(), me.getY());
                                          JList theList = (JList) me.getSource();
                                          indexChangesColor = theList.locationToIndex(me.getPoint());
                                      }
                                  }
                              }
        );
        list2Finance.addMouseListener(new MouseAdapter() {
                                  public void mouseClicked(MouseEvent me) {
                                      if (SwingUtilities.isRightMouseButton(me)) {
                                          popupMenu.show(list2Finance, me.getX(), me.getY());
                                          JList theList = (JList) me.getSource();
                                          indexChangesColor = theList.locationToIndex(me.getPoint());
                                      }
                                  }
                              }
        );
        list2Images.addMouseListener(new MouseAdapter() {
                                  public void mouseClicked(MouseEvent me) {
                                      if (SwingUtilities.isRightMouseButton(me)) {
                                          popupMenu.show(list2Images, me.getX(), me.getY());
                                          JList theList = (JList) me.getSource();
                                          indexChangesColor = theList.locationToIndex(me.getPoint());
                                      }
                                  }
                              }
        );
        list2Scratchpad.addMouseListener(new MouseAdapter() {
                                  public void mouseClicked(MouseEvent me) {
                                      if (SwingUtilities.isRightMouseButton(me)) {
                                          popupMenu.show(list2Scratchpad, me.getX(), me.getY());
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
                list2DO.setCellRenderer(new MyListCellRenderer());
                list2Finance.setCellRenderer(new MyListCellRenderer());
                list2Images.setCellRenderer(new MyListCellRenderer());
                list2Scratchpad.setCellRenderer(new MyListCellRenderer());
            }
        });
        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementsToColor.remove(Integer.valueOf(indexChangesColor));
                list2DO.setCellRenderer(new MyListCellRenderer());
                list2Finance.setCellRenderer(new MyListCellRenderer());
                list2Images.setCellRenderer(new MyListCellRenderer());
                list2Scratchpad.setCellRenderer(new MyListCellRenderer());
            }
        });

    }


    public void changeAddViews2(String ss){
        this.remove(boxPanel);
        if(whichList==1){
            firstCategories.secondCategoriesDO.addElement(ss);
            this.remove(list2DO);
            boxPanel.add(list2DO);
        }
        else if(whichList==2){
            firstCategories.secondCategoriesFinance.addElement(ss);
            this.remove(list2Finance);
            boxPanel.add(list2Finance);
        }
        else if(whichList==3){
            firstCategories.secondCategoriesImages.addElement(ss);
            this.remove(list2Images);
            boxPanel.add(list2Images);
        }
        else if(whichList==4){
            firstCategories.secondCategoriesScratchpad.addElement(ss);
            this.remove(list2Scratchpad);
            boxPanel.add(list2Scratchpad);
        }
        this.add(boxPanel);
        this.add(borderPanel);
        this.revalidate();
        this.repaint();
    }


    public void changeDelView2(){
        Integer selectedIndex = 0;

        if(whichList==1){
            selectedIndex = list2DO.getSelectedIndex();
        }
        else if(whichList==2){
            selectedIndex = list2Finance.getSelectedIndex();
        }
        else if(whichList==3){
            selectedIndex = list2Images.getSelectedIndex();
        }
        else if(whichList==4){
            selectedIndex = list2Scratchpad.getSelectedIndex();
        }

        elementsToColorTemporary.clear();
        for(int x : elementsToColor){
            elementsToColorTemporary.add(x);
        }

        for(int y : elementsToColor){
            if(selectedIndex < y){
                elementsToColorTemporary.remove(Integer.valueOf(y));
                elementsToColorTemporary.add(y-1);
            }
            else if(selectedIndex.equals(y)){
                elementsToColorTemporary.remove(Integer.valueOf(y));
            }
        }
        elementsToColor.clear();
        for(int z : elementsToColorTemporary){
            elementsToColor.add(z);
        }


        if (selectedIndex != -1) {
            if(whichList==1){
                firstCategories.secondCategoriesDO.remove(selectedIndex);
            }
            else if(whichList==2){
                firstCategories.secondCategoriesFinance.remove(selectedIndex);
            }
            else if(whichList==3){
                firstCategories.secondCategoriesImages.remove(selectedIndex);
            }
            else if(whichList==4){
                firstCategories.secondCategoriesScratchpad.remove(selectedIndex);
            }
        }
        this.remove(boxPanel);
        this.remove(borderPanel);
        this.add(boxPanel);
        this.add(borderPanel);
        this.revalidate();
        this.repaint();
    }
    public void myFirstView(){
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(list1, BorderLayout.PAGE_START);
        this.add(buttonChoose, BorderLayout.PAGE_END);
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if(whichList==1){
            boxPanel.removeAll();
            boxPanel.add(list2DO);
        }
        else if(whichList==2){
            boxPanel.removeAll();
            boxPanel.add(list2Finance);
        }
        else if(whichList==3){
            boxPanel.removeAll();
            boxPanel.add(list2Images);
        }
        else if(whichList==4){
            boxPanel.removeAll();
            boxPanel.add(list2Scratchpad);
        }

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
                    if(objList.toString().equals("TO-DO")){
                        whichList = 1;
                    }
                    else if(objList.toString().equals("Finance")){
                        whichList = 2;
                    }
                    else if(objList.toString().equals("Images")){
                        whichList = 3;
                    }
                    else if(objList.toString().equals("Scratchpad")){
                        whichList = 4;
                    }
                    System.out.println(objList.toString());
                    mySecondViews();
                    }
            }
            if(e.getSource()==buttonBack){
                myFirstView();
            }
            if(e.getSource()==buttonChoose){
                mySecondViews();
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



