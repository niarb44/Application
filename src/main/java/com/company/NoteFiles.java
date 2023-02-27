package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;

public class NoteFiles {

    public void noteFilesExecute() {

        try {

            RandomAccessFile RAF = new RandomAccessFile("nowy.txt", "rw");
            StringBuffer buffer = new StringBuffer();


            while(RAF.getFilePointer() < RAF.length()) {
                buffer.append(RAF.readLine()+System.lineSeparator());
            }
            String contents = buffer.toString();
            System.out.println("Contents of the file : "+contents);


            RAF.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
