package svgeditor.GuiComponents.Buttons;

import svgeditor.Utils.GraphicObjectManager;
import svgeditor.Utils.FileManager.FileLoader;
import svgeditor.Utils.Serializers.XmlSerializer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class XmlImportButton extends JButton {
    public XmlImportButton() {
        super("Import XML");

        this.addActionListener((event) -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("svg", "svg");
            fileChooser.setFileFilter(filter);
            fileChooser.showSaveDialog(null);

            if(fileChooser.getSelectedFile() == null)
                return;

            var directory = fileChooser.getSelectedFile().getPath();
            FileLoader fileLoader = new FileLoader();
            var data = fileLoader.load(directory);
            XmlSerializer serializer = new XmlSerializer();

            serializer.deserialize(data);
        });
    }
}
