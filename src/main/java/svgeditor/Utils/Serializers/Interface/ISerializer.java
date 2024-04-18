package svgeditor.Utils.Serializers.Interface;

import svgeditor.GraphicsObjects.GraphicObject;

import jakarta.xml.bind.JAXBException;
import java.util.List;

public interface ISerializer {
    public String Serialize();

    public void Deserialize(String text);
}
