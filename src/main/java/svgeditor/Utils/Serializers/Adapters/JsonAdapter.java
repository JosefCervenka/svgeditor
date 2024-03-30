package svgeditor.Utils.Serializers.Adapters;

import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import svgeditor.GraphicsObjects.Ellipse;
import svgeditor.GraphicsObjects.GraphicObject;
import svgeditor.GraphicsObjects.Line;
import svgeditor.GraphicsObjects.Rectangle;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class JsonAdapter implements JsonSerializer<GraphicObject>, JsonDeserializer<GraphicObject> {
    public JsonElement serialize(GraphicObject object, java.lang.reflect.Type typeOfSrc, com.google.gson.JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", String.valueOf(object.type));
        jsonObject.addProperty("lineSize", object.lineSize);
        jsonObject.addProperty("color", object.color);

        switch (object.getClass().getSimpleName()){
            case "Line" -> {
                Line line = (Line)object;
                jsonObject.addProperty("x1", line.x1);
                jsonObject.addProperty("x2", line.x2);
                jsonObject.addProperty("y1", line.y1);
                jsonObject.addProperty("y2", line.y2);
            }
            case "Ellipse" -> {
                Ellipse ellipse = (Ellipse) object;
                jsonObject.addProperty("x1", ellipse.x1);
                jsonObject.addProperty("x2", ellipse.x2);
                jsonObject.addProperty("height", ellipse.height);
                jsonObject.addProperty("width", ellipse.width);
            }
            case "Rectangle" -> {
                Rectangle rectangle = (Rectangle)object;
                jsonObject.addProperty("x1", rectangle.x1);
                jsonObject.addProperty("x2", rectangle.x2);
                jsonObject.addProperty("height", rectangle.height);
                jsonObject.addProperty("width", rectangle.width);
            }
        }

        return jsonObject;
    }

    public GraphicObject deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String objectType = jsonObject.get("type").getAsString();

        switch (objectType) {
            case "Line" -> {
                return context.deserialize(json, Line.class);
            }
            case "Ellipse" -> {
                return context.deserialize(json, Ellipse.class);
            }
            case "Rectangle" -> {
                return context.deserialize(json, Rectangle.class);
            }

            default -> {
                return null;
            }
        }
    }

    public List<GraphicObject> deserializeHashMap(List<LinkedTreeMap<String, ?>> data)  {
        List<GraphicObject> graphicObjects = new ArrayList<>();

        for (var item : data){
            Class<?> graphicObjectClass = null;
            try {
                graphicObjectClass = Class.forName(((String) item.get("type")).replace("class ", ""));
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

            instanceOfGraphicObject.lineSize = (Double) item.get("lineSize");
            instanceOfGraphicObject.color = (String) item.get("color");

            switch (instanceOfGraphicObject.getClass().getSimpleName()) {
                case "Line" -> {
                    Line line = (Line) instanceOfGraphicObject;
                    line.x1 = (Double) item.get("x1");
                    line.x2 = (Double) item.get("x2");
                    line.y1 = (Double) item.get("y1");
                    line.y2 = (Double) item.get("y2");

                    line.type = line.getClass();
                }
                case "Ellipse" -> {
                    Ellipse ellipse = (Ellipse) instanceOfGraphicObject;
                    ellipse.x1 = (Double)(item.get("x1"));
                    ellipse.x2 = (Double)(item.get("x2"));
                    ellipse.width = (Double)(item.get("width"));
                    ellipse.height = (Double)(item.get("height"));

                    ellipse.type = ellipse.getClass();
                }
                case "Rectangle" -> {
                    Rectangle rectangle = (Rectangle) instanceOfGraphicObject;
                    rectangle.x1 = (Double)(item.get("x1"));
                    rectangle.x2 = (Double)(item.get("x2"));
                    rectangle.width = (Double)(item.get("width"));
                    rectangle.height = (Double)(item.get("height"));

                    rectangle.type = rectangle.getClass();
                }
            }

            graphicObjects.add(instanceOfGraphicObject);
        }

        return graphicObjects;
    }
}
