package svgeditor.Utils;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import svgeditor.GraphicsObjects.GraphicObject;
import svgeditor.GuiComponents.Panels.DrawingPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private static Graphics2D graphics;

    private static DrawingPanel drawingPanel;

    public static void init(Graphics2D graphics2D, DrawingPanel panel) {
        graphics = graphics2D;
        drawingPanel = panel;
        drawAll();
    }

    public static void setGraphicsObjects(List<GraphicObject> graphicObjectList){
        graphicObjects = graphicObjectList;
        drawAll();
    }
    @JacksonXmlElementWrapper(useWrapping = false)
    public static List<GraphicObject> graphicObjects = new ArrayList<GraphicObject>();

    public static void add(GraphicObject drawable) {
        graphicObjects.add(drawable);
        drawAll();
    }

    public static void remove(GraphicObject drawable) {
        graphicObjects.remove(drawable);
        drawAll();
    }

    public static void drawAll() {
        for (var item : graphicObjects) {
            item.Draw(graphics);
        }
        drawingPanel.repaint();
    }
}
