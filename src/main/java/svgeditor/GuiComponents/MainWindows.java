package svgeditor.GuiComponents;

import svgeditor.GraphicsObjects.Ellipse;
import svgeditor.GraphicsObjects.GraphicObject;
import svgeditor.GraphicsObjects.Line;
import svgeditor.GraphicsObjects.Rectangle;
import svgeditor.GuiComponents.Panels.*;
import svgeditor.Utils.GraphicObjectManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainWindows extends JFrame {
    public MainWindows(){
        setTitle("Drawing");

        setSize(400, 300);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

        setBackground(Color.blue);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        DrawingToolsPanel drawingManagerPanel = new DrawingToolsPanel();
        add(drawingManagerPanel, BorderLayout.NORTH);

        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel, BorderLayout.CENTER);

        ObjectManagerPanel objectManagerPanel = new ObjectManagerPanel();
        add(objectManagerPanel, BorderLayout.EAST);

        XmlEditorPanel xmlEditorPanel = new XmlEditorPanel();
        add(xmlEditorPanel, BorderLayout.WEST);

        ExportPanel exportPanel = new ExportPanel();
        add(exportPanel, BorderLayout.SOUTH);



        List<GraphicObject> graphicObjects = new ArrayList<>();
        GraphicObjectManager.set(graphicObjects);
    }

}
