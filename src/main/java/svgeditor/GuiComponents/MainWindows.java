package svgeditor.GuiComponents;

import svgeditor.GuiComponents.Buttons.ExportButton;
import svgeditor.GuiComponents.Buttons.ImportButton;
import svgeditor.GuiComponents.Panels.DrawingPanel;
import svgeditor.GuiComponents.Panels.ExportPanel;
import svgeditor.Utils.Serializers.JsonSerializer;
import svgeditor.Utils.Serializers.XmlSerializer;

import javax.swing.*;
import java.awt.*;

public class MainWindows extends JFrame {
    public MainWindows(){
        setTitle("Drawing");

        setPreferredSize(new Dimension(300,300));
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

        setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        DrawingPanel drawingPanel = new DrawingPanel();


        add(drawingPanel, BorderLayout.CENTER);

        ExportPanel exportPanel = new ExportPanel();
        add(exportPanel, BorderLayout.SOUTH);

        var jsonSerializerExportButton = new ExportButton<>("JSON EXPORT", new JsonSerializer(), "exportSVGEditor.json");
        var xmlSerializerExportButton = new ExportButton<>("XML EXPORT", new XmlSerializer(), "exportSVGEditor.xml");
        var jsonSeriliazerImportButton = new ImportButton<>("JSON IMPORT", new JsonSerializer(),"json");
        var xmlSeriliazerImportButton = new ImportButton<>("XML IMPORT", new XmlSerializer(),"xml");

        exportPanel.add(jsonSerializerExportButton);
        exportPanel.add(xmlSerializerExportButton);
        exportPanel.add(jsonSeriliazerImportButton);
        exportPanel.add(xmlSeriliazerImportButton);

    }

}
