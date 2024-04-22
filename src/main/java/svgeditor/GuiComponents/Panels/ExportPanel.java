package svgeditor.GuiComponents.Panels;

import svgeditor.GuiComponents.Buttons.JsonExportButton;
import svgeditor.GuiComponents.Buttons.XmlExportButton;
import svgeditor.GuiComponents.Buttons.XmlImportButton;

import javax.swing.*;

public class ExportPanel extends JPanel {

    public ExportPanel(){
        JsonExportButton jsonExportButton = new JsonExportButton();
        XmlExportButton xmlExportButton = new XmlExportButton();
        XmlImportButton xmlImportButton = new XmlImportButton();

        add(jsonExportButton);
        add(xmlExportButton);
        add(xmlImportButton);
    }
}
