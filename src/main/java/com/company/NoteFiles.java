package com.company;

import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class NoteFiles {

//    public void noteFilesExecute() {
//
//        try {
//
//            RandomAccessFile RAF = new RandomAccessFile("nowy.txt", "rw");
//            StringBuffer buffer = new StringBuffer();
//
//
//            while(RAF.getFilePointer() < RAF.length()) {
//                buffer.append(RAF.readLine()+System.lineSeparator());
//            }
//            String contents = buffer.toString();
//            System.out.println("Contents of the file : "+contents);
//
//
//            RAF.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public void noteFilesExecute2(){
            // Dane do zapisania
            String data = "Hello, World!";

            // Utwórz obiekt File dla pliku, do którego chcesz zapisać dane
            File file = new File("example.txt");

            try {
                // Użyj funkcji FileUtils.write() do zapisu danych do pliku
                FileUtils.write(file, data, "UTF-8");
                System.out.println("Dane zostały zapisane do pliku.");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
