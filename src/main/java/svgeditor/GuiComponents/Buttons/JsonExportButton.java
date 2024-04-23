package svgeditor.GuiComponents.Buttons;

import svgeditor.Utils.FileManager.FileGenerator;
import svgeditor.Utils.Serializers.JsonSerializer;

import javax.swing.*;

public class JsonExportButton extends JButton {
    public  JsonExportButton() {
        super("Export JSON");
        this.addActionListener((event) -> {
        JsonSerializer serializer = new JsonSerializer();
        var data = serializer.serialize();

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showSaveDialog(null);

        if(fileChooser.getSelectedFile() == null)
            return;

        var directory = fileChooser.getSelectedFile().getPath();

        FileGenerator fileGenerator = new FileGenerator();
        fileGenerator.create("picture", "json", directory, data);
        });
    }

}
