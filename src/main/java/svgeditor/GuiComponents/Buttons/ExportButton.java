package svgeditor.GuiComponents.Buttons;

import svgeditor.Utils.ObjectManager;
import svgeditor.Utils.Serializers.FileManagers.FileGenerator;
import svgeditor.Utils.Serializers.Interfaces.ISerializer;
import javax.swing.*;

public class ExportButton<TSerializer extends ISerializer> extends JButton  {
    private final TSerializer serializer;
    public ExportButton(String label, TSerializer serializer, String fileName){
        super(label);
        this.serializer = serializer;
        this.addActionListener((event) -> {

            String serializeData = this.serializer.serialize(ObjectManager.getGraphicObjects());

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showSaveDialog(null);

            if(fileChooser.getSelectedFile() == null)
                return;

            var directory = fileChooser.getSelectedFile().getPath();



            FileGenerator fileGenerator = new FileGenerator();
            fileGenerator.create(fileName, directory, serializeData);
        });
    }
}
