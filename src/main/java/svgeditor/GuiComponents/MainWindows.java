package svgeditor.GuiComponents;

import svgeditor.GuiComponents.Buttons.ExportButton;
import svgeditor.GuiComponents.Buttons.ImportButton;
import svgeditor.GuiComponents.Panels.DrawingPanel;
import svgeditor.GuiComponents.Panels.ExportPanel;
import svgeditor.GuiComponents.Panels.ObjectManagerPanel;
import svgeditor.GuiComponents.Tables.GraphicsObjectTable;
import svgeditor.Utils.Serializers.JsonSerializer;
import svgeditor.Utils.Serializers.XmlSerializer;

import javax.swing.*;
import java.awt.*;

public class MainWindows extends JFrame {
    public MainWindows(){
        setTitle("Drawing");

        setSize(400, 300);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

        setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        ExportPanel exportPanel = new ExportPanel();
        add(exportPanel, BorderLayout.SOUTH);

        ObjectManagerPanel objectManagerPanel = new ObjectManagerPanel();
        add(objectManagerPanel, BorderLayout.EAST);
    }

}
