package svgeditor.Utils;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import svgeditor.GraphicsObjects.GraphicObject;
import svgeditor.GuiComponents.Panels.DrawingPanel;
import svgeditor.GuiComponents.Tables.GraphicsObjectTable;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectManager {
    private static Graphics2D graphics;

    private static GraphicsObjectTable objectTable;

    private static DrawingPanel drawingPanel;

    @JacksonXmlElementWrapper(useWrapping = false)
    private static List<GraphicObject> graphicObjects = new ArrayList<GraphicObject>();

    public static void setGraphicsObjectTable(GraphicsObjectTable graphicsObjectTable){
        objectTable = graphicsObjectTable;
        revalidateTable();
    }

    public static void setDrawingPanel(Graphics2D graphics2D, DrawingPanel panel) {
        graphics = graphics2D;
        drawingPanel = panel;
    }

    public static void setGraphicsObjects(List<GraphicObject> graphicObjectList){
        graphicObjects = graphicObjectList;
        drawAll();
        revalidateTable();
    }

    public static List<GraphicObject> getGraphicObjects(){
        return graphicObjects;
    }

    public static void add(GraphicObject drawable) {
        graphicObjects.add(drawable);
        drawAll();
        revalidateTable();
    }

    public static void remove(GraphicObject drawable) {
        graphicObjects.remove(drawable);
        drawAll();
        revalidateTable();
    }

    public static void revalidateTable(){
        Random random = new Random();
        String[] headers = new String[]{
                "type", "color", "lineSize"
        };
        DefaultTableModel model = new DefaultTableModel(headers, 10);
        for (var object : graphicObjects){
            model.addRow(new Object[]{
                    "1",
                    "2",
                    "3",
            });
        }

        objectTable.setModel(model);
        objectTable.revalidate();
    }

    public static void drawAll() {
        for (var item : graphicObjects) {
            item.Draw(graphics);
        }
        drawingPanel.repaint();
    }
}
