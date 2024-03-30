package svgeditor.Utils.Serializers.Interfaces;

import svgeditor.GraphicsObjects.GraphicObject;

import java.util.List;

public interface ISerializer {
    public String serialize(List<GraphicObject> graphicObjects);

    public List<GraphicObject> deserialize(String text);
}
