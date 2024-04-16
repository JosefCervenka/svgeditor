package svgeditor.GuiComponents.Panels;

import svgeditor.GuiComponents.Buttons.ExportButton;
import svgeditor.GuiComponents.Buttons.ImportButton;
import svgeditor.Utils.Serializers.JsonSerializer;
import svgeditor.Utils.Serializers.XmlSerializer;

import javax.swing.*;
import java.awt.*;

public class ExportPanel extends JPanel {

    public ExportPanel(){
        setBackground(Color.LIGHT_GRAY);

        var jsonSerializerExportButton = new ExportButton<>("JSON EXPORT", new JsonSerializer(), "exportSVGEditor.json");
        var xmlSerializerExportButton = new ExportButton<>("XML EXPORT", new XmlSerializer(), "exportSVGEditor.xml");
        var jsonSeriliazerImportButton = new ImportButton<>("JSON IMPORT", new JsonSerializer(),"json");
        var xmlSeriliazerImportButton = new ImportButton<>("XML IMPORT", new XmlSerializer(),"xml");

        add(jsonSerializerExportButton);
        add(xmlSerializerExportButton);
        add(jsonSeriliazerImportButton);
        add(xmlSeriliazerImportButton);
    }
}
