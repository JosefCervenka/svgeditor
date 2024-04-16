package svgeditor.GuiComponents.Buttons;

import svgeditor.Utils.GraphicObjectManager;
import svgeditor.Utils.Serializers.FileManagers.FileGenerator;
import svgeditor.Utils.Serializers.Interfaces.ISerializable;
import javax.swing.*;

public class ExportButton<TSerializer extends ISerializable> extends JButton  {
    private final TSerializer serializer;
    public ExportButton(String label, TSerializer serializer, String fileName){
        super(label);
        this.serializer = serializer;
        this.addActionListener((event) -> {

            String serializeData = this.serializer.serialize(GraphicObjectManager.getAll());

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
