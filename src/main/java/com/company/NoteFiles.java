package com.company;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class NoteFiles {

    public void noteFilesExecute2(String title, String title2){
            String data2 = title2;

            File file = new File(title+".txt");

            try {
                FileUtils.write(file, title2, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
