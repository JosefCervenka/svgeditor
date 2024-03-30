package svgeditor.Utils.Serializers.Adapters;

import svgeditor.GraphicsObjects.Ellipse;
import svgeditor.GraphicsObjects.GraphicObject;
import svgeditor.GraphicsObjects.Line;
import svgeditor.GraphicsObjects.Rectangle;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class XmlAdapter {
    public List<GraphicObject> deserialize(List<LinkedHashMap<String, String>> data)  {
    List<GraphicObject> graphicObjects = new ArrayList<>();

        for (var item : data){
            Class<?> graphicObjectClass = null;
            try {
                graphicObjectClass = Class.forName(item.get("type").replace("class ", ""));
            } catch (ClassNotFoundException e) {
                return null;
            }
            GraphicObject instanceOfGraphicObject = null;
            try {
                instanceOfGraphicObject = (GraphicObject) graphicObjectClass.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                return null;
            } catch (IllegalAccessException e) {
                return null;
            } catch (InvocationTargetException e) {
                return null;
            } catch (NoSuchMethodException e) {
                return null;
            }

            instanceOfGraphicObject.lineSize = Double.parseDouble(item.get("lineSize"));
            instanceOfGraphicObject.color = item.get("color");

            switch (instanceOfGraphicObject.getClass().getSimpleName()) {
                case "Line" -> {
                    Line line = (Line) instanceOfGraphicObject;
                    line.x1 = Double.parseDouble(item.get("x1"));
                    line.x2 = Double.parseDouble(item.get("x2"));
                    line.y1 = Double.parseDouble(item.get("y1"));
                    line.y2 = Double.parseDouble(item.get("y2"));

                    line.type = line.getClass();
                }
                case "Ellipse" -> {
                    Ellipse ellipse = (Ellipse) instanceOfGraphicObject;
                    ellipse.x1 = Double.parseDouble(item.get("x1"));
                    ellipse.x2 = Double.parseDouble(item.get("x2"));
                    ellipse.width = Double.parseDouble(item.get("width"));
                    ellipse.height = Double.parseDouble(item.get("height"));

                    ellipse.type = ellipse.getClass();
                }
                case "Rectangle" -> {
                    Rectangle rectangle = (Rectangle) instanceOfGraphicObject;
                    rectangle.x1 = Double.parseDouble(item.get("x1"));
                    rectangle.x2 = Double.parseDouble(item.get("x2"));
                    rectangle.width = Double.parseDouble(item.get("width"));
                    rectangle.height = Double.parseDouble(item.get("height"));

                    rectangle.type = rectangle.getClass();
                }
            }

            graphicObjects.add(instanceOfGraphicObject);
        }

        return graphicObjects;
    }
}
