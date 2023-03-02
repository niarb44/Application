package com.company;

import org.apache.commons.io.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NoteFiles {

    public void noteFilesExecute2(String title, String title2, int whichList){
            String data2 = title2;

            File file = new File(title+"-"+whichList+".txt");

            if(file.exists()){
                JDialog dialog = new JDialog();
                JLabel label = new JLabel("THE TASK ALREADY EXISTS!!!!");
                label.setForeground(Color.RED);
                label.setBackground(Color.BLACK);
                dialog.add(label);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setModal(true);
                Container contentPane = dialog.getContentPane();
                contentPane.setBackground(Color.BLACK);
                dialog.setVisible(true);
                dialog.setVisible(true);
            }
            else{
                try {
                    FileUtils.write(file, title2, "UTF-8");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }

}
