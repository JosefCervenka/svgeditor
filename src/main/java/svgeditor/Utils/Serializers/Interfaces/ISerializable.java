package svgeditor.Utils.Serializers.Interfaces;

import svgeditor.GraphicsObjects.GraphicObject;

import java.util.List;

public interface ISerializable {
    public String serialize(List<GraphicObject> graphicObjects);

    public List<GraphicObject> deserialize(String text);
}
