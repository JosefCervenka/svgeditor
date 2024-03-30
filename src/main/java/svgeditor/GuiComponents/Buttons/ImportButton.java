package svgeditor.GuiComponents.Buttons;

import svgeditor.Utils.ObjectManager;
import svgeditor.Utils.Serializers.FileManagers.FileLoader;
import svgeditor.Utils.Serializers.Interfaces.ISerializer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImportButton<TSerializer extends ISerializer> extends JButton {
    private final TSerializer serializer;

    public ImportButton(String label, TSerializer serializer, String fileType) {
        super(label);
        this.serializer = serializer;

        this.addActionListener((event) -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter(fileType + "files", fileType);
            fileChooser.setFileFilter(filter);
            fileChooser.showSaveDialog(null);

            if(fileChooser.getSelectedFile() == null)
                return;

            var directory = fileChooser.getSelectedFile().getPath();
            FileLoader fileLoader = new FileLoader();
            var data = fileLoader.load(directory);
            var listGraphicsObjects = this.serializer.deserialize(data);

            ObjectManager.setGraphicsObjects(listGraphicsObjects);
        });
    }
}
