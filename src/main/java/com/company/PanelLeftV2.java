package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PanelLeftV2 extends JPanel {

    JList<String> list2DO;
    JList<String> list2Finance;
    JList<String> list2Images;
    JList<String> list2Scratchpad;
    ArrayList<Integer> elementsToColor = new ArrayList<Integer>();
    ArrayList<Integer> elementsToColorTemporary = new ArrayList<Integer>();
    ArrayList<JList> listOfSecond = new ArrayList<JList>();
    PanelCenter panelCenter = new PanelCenter();
    JButton buttonAdd2 = new JButton("ADD");
    JButton buttonDel22 = new JButton("DEL");
    JButton buttonBack = new JButton("BACK");
    int indexChangesColor = 0;
    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem jmi1, jmi2;
    JPanel borderPanel = new JPanel();
    JPanel boxPanel = new JPanel();
    FirstCategories firstCategories = new FirstCategories();
    int whichList ;


    PanelLeftV2() {
        initComponentsPanel();
    }

    public void initComponentsPanel() {
        System.out.println(whichList);
        list2DO = new JList<>(firstCategories.secondCategoriesDO);
        list2Finance = new JList<>(firstCategories.secondCategoriesFinance);
        list2Images = new JList<>(firstCategories.secondCategoriesImages);
        list2Scratchpad = new JList<>(firstCategories.secondCategoriesScratchpad);
        listOfSecond.add(list2DO);
        listOfSecond.add(list2Finance);
        listOfSecond.add(list2Images);
        listOfSecond.add(list2Scratchpad);

        popupMenu.add(jmi1= new JMenuItem("Done"));
        popupMenu.add(new JPopupMenu.Separator());
        popupMenu.add(jmi2 = new JMenuItem("Not-Done"));

        this.setPreferredSize(new Dimension(110, 250));
        for(JList x: listOfSecond){
            x.setPreferredSize(new Dimension(110, 200));
        }

        buttonAdd2.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonDel22.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonBack.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonAdd2.setPreferredSize(new Dimension(55, 25));
        buttonDel22.setPreferredSize(new Dimension(55, 25));
        for(JList x: listOfSecond){
            x.setFont(new Font("Arial", Font.BOLD, 13));
        }

        this.setLayout(new BorderLayout());


        for(JList x: listOfSecond){
            x.setCellRenderer(new MyListCellRenderer());
        }

        for(JList x: listOfSecond){

            x.addMouseListener(new MouseAdapter() {
                                   public void mouseClicked(MouseEvent me) {
                                       if (SwingUtilities.isRightMouseButton(me)) {
                                           popupMenu.show(x, me.getX(), me.getY());
                                           JList theList = (JList) me.getSource();
                                           indexChangesColor = theList.locationToIndex(me.getPoint());
                                       }
                                   }
                               }
            );

        }

        jmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementsToColor.add(indexChangesColor);
                for(JList x: listOfSecond){
                    x.setCellRenderer(new MyListCellRenderer());
                }
            }
        });

        jmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elementsToColor.remove(Integer.valueOf(indexChangesColor));
                for(JList x: listOfSecond){
                    x.setCellRenderer(new MyListCellRenderer());
                }
            }
        });

        borderPanel.setLayout(new BorderLayout());
        borderPanel.setPreferredSize(new Dimension(110, 50));
        borderPanel.add(buttonAdd2, BorderLayout.LINE_START);
        borderPanel.add(buttonDel22, BorderLayout.LINE_END);
        borderPanel.add(buttonBack, BorderLayout.PAGE_END);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(boxPanel);
        this.add(borderPanel);
        this.revalidate();
        this.repaint();
        System.out.println(whichList);
    }

    public void changeAddViews2(String ss){
        System.out.println(whichList);
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
        System.out.println(whichList);
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


    public class MyListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            renderer.setBackground(new Color(255,102,102));
            for(int x : elementsToColor){
                if(index == x){
                    renderer.setBackground(Color.GREEN);
                }
            }
            return renderer;
        }
    }

}
