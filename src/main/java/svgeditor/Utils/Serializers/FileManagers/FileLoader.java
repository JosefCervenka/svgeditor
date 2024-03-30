package svgeditor.Utils.Serializers.FileManagers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileLoader {
    public String load(String path) {
        StringBuilder data = new StringBuilder();
        try {
            File myObj = new File(path);
            Scanner scanner = new Scanner(myObj);
            while (scanner.hasNextLine()) {
                data.append(scanner.nextLine());
                data.append("\n");
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return data.toString();
    }

}
