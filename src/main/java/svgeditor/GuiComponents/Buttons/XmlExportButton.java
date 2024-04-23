package svgeditor.GuiComponents.Buttons;

import svgeditor.Utils.FileManager.FileGenerator;
import svgeditor.Utils.Serializers.XmlSerializer;

import javax.swing.*;

public class XmlExportButton extends JButton {
    public XmlExportButton() {
        super("Export XML");

        this.addActionListener((event) -> {
            XmlSerializer serializer = new XmlSerializer();
            var data = serializer.serialize();

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showSaveDialog(null);

            if(fileChooser.getSelectedFile() == null)
                return;

            var directory = fileChooser.getSelectedFile().getPath();

            FileGenerator fileGenerator = new FileGenerator();
            fileGenerator.create("picture","svg", directory, data);
        });
    }
}
