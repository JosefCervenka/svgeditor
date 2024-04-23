package svgeditor.Utils.FileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {

    public void create(String fileName, String typeOfFile, String path, String data) {

        File directory = new File(path);
        File file = new File(directory, fileName + "." + typeOfFile);

        int index = 0;
        while (file.exists()) {
            file = new File(directory, fileName + "(" + (index++) + ")" + "." + typeOfFile);
        }

        try {

            if (file.createNewFile()) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(data);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}