package svgeditor.Utils.Serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import svgeditor.GraphicsObjects.GraphicObject;
import svgeditor.Utils.Serializers.Adapters.XmlAdapter;
import svgeditor.Utils.Serializers.Interfaces.ISerializable;

import java.util.ArrayList;
import java.util.List;

public class XmlSerializer implements ISerializable {
    XmlMapper mapper = new XmlMapper();

    public XmlSerializer(){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Override
    public String serialize(List<GraphicObject> graphicObjects) {
        String data;
        try {
            data = mapper.writeValueAsString(graphicObjects);
        } catch (JsonProcessingException e) {
            return null;
        }
        return data;
    }

    @Override
    public List<GraphicObject> deserialize(String text) {
        List<GraphicObject> graphicObjects = new ArrayList<>();
        try {
            var objects = mapper.readValue(text, new ArrayList<GraphicObject>().getClass());
            XmlAdapter adapter = new XmlAdapter();


            graphicObjects = adapter.deserialize(objects);


        } catch (JsonProcessingException e) {
            return null;
        }
        return graphicObjects;
    }
}
