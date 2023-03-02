package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

// left side of frame(in second view) - with tasks
public class PanelLeftV2 extends JPanel {

    JList<String> list2DO;
    JList<String> list2Finance;
    JList<String> list2Images;
    JList<String> list2Scratchpad;
    ArrayList<Integer> elementsToColor = new ArrayList<>();
    ArrayList<Integer> elementsToColorTemporary = new ArrayList<>();
    ArrayList<JList> listOfSecond = new ArrayList<>();
    JButton buttonAdd2 = new JButton("ADD");
    JButton buttonDel22 = new JButton("DEL");
    JButton buttonBack = new JButton("BACK");
    int indexChangesColor = 0;
    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem menuItem1, menuItem2;
    JPanel borderPanel = new JPanel();
    JPanel boxPanel = new JPanel();
    FirstCategories firstCategories = new FirstCategories();
    int whichList ;
    MyMouseAdapter myMouseAdapter = new MyMouseAdapter();



    PanelLeftV2() {
        initComponentsPanel();
    }

    public void initComponentsPanel() {
        list2DO = new JList<>(firstCategories.secondCategoriesDO);
        list2Finance = new JList<>(firstCategories.secondCategoriesFinance);
        list2Images = new JList<>(firstCategories.secondCategoriesImages);
        list2Scratchpad = new JList<>(firstCategories.secondCategoriesScratchpad);
        listOfSecond.add(list2DO);
        listOfSecond.add(list2Finance);
        listOfSecond.add(list2Images);
        listOfSecond.add(list2Scratchpad);

        popupMenu.add(menuItem1= new JMenuItem("Done"));
        popupMenu.add(new JPopupMenu.Separator());
        popupMenu.add(menuItem2 = new JMenuItem("Not-Done"));

        this.setPreferredSize(new Dimension(110, 250));
        buttonAdd2.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonDel22.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonBack.setFont(new Font("Arial", Font.PLAIN, 9));
        buttonAdd2.setPreferredSize(new Dimension(55, 25));
        buttonDel22.setPreferredSize(new Dimension(55, 25));

        for(JList x: listOfSecond){
            x.setPreferredSize(new Dimension(110, 200));
            x.setFont(new Font("Arial", Font.BOLD, 13));
            x.setCellRenderer(new MyListCellRenderer());
            x.addMouseListener(myMouseAdapter);
        }

        this.setLayout(new BorderLayout());

        menuItem1.addActionListener(e -> {
            elementsToColor.add(indexChangesColor);
            for(JList x: listOfSecond){
                x.setCellRenderer(new MyListCellRenderer());
            }
        });

        menuItem2.addActionListener(e -> {
            elementsToColor.remove(Integer.valueOf(indexChangesColor));
            for(JList x: listOfSecond){
                x.setCellRenderer(new MyListCellRenderer());
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
    }

    public void changeAddViews2(String ss){
        if(whichList==1){
            firstCategories.secondCategoriesDO.addElement(ss);
        }
        else if(whichList==2){
            firstCategories.secondCategoriesFinance.addElement(ss);
        }
        else if(whichList==3){
            firstCategories.secondCategoriesImages.addElement(ss);
        }
        else if(whichList==4){
            firstCategories.secondCategoriesScratchpad.addElement(ss);
        }
    }

    public void changeDelView2(){
        Integer selectedIndex = 0;
        String selectedName = "";

        if(whichList==1){
            selectedIndex = list2DO.getSelectedIndex();
            selectedName = list2DO.getSelectedValue();
        }
        else if(whichList==2){
            selectedIndex = list2Finance.getSelectedIndex();
            selectedName = list2Finance.getSelectedValue();
        }
        else if(whichList==3){
            selectedIndex = list2Images.getSelectedIndex();
            selectedName = list2Images.getSelectedValue();
        }
        else if(whichList==4){
            selectedIndex = list2Scratchpad.getSelectedIndex();
            selectedName = list2Scratchpad.getSelectedValue();
        }

        File file = new File(selectedName+"-"+whichList+".txt");
        file.delete();

        elementsToColorTemporary.clear();
        for(int x : elementsToColor){
            elementsToColorTemporary.add(x);

            if(selectedIndex < x){
                elementsToColorTemporary.remove(Integer.valueOf(x));
                elementsToColorTemporary.add(x-1);
            }
            else if(selectedIndex.equals(x)){
                elementsToColorTemporary.remove(Integer.valueOf(x));
            }
        }

        elementsToColor.clear();
        elementsToColor.addAll(elementsToColorTemporary);


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

    public class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isRightMouseButton(e)) {
                JList theList = (JList) e.getSource();
                popupMenu.show(theList, e.getX(), e.getY());
                indexChangesColor = theList.locationToIndex(e.getPoint());
            }
        }
    }
}
