package svgeditor.Utils.Serializers;

import svgeditor.Utils.GraphicObjectManager;
import svgeditor.Utils.Serializers.DTOs.Svg;
import svgeditor.Utils.Serializers.Interface.ISerializer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

public class XmlSerializer implements ISerializer {
    public String serialize() {
        Svg svg = new Svg();
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(svg.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter stringWriter = new StringWriter();

            if(GraphicObjectManager.getAll() != null) {
                svg.objects = GraphicObjectManager.getAll();
            }

            marshaller.marshal(svg, stringWriter);
            return stringWriter.toString();


        } catch (JAXBException e) {
            return "Error while serializing to XML.";
        }
    }

    public void deserialize(String text) {
        try {
            JAXBContext context = JAXBContext.newInstance(Svg.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader stringReader = new StringReader(text);
            Svg svg = (Svg) unmarshaller.unmarshal(stringReader);
            GraphicObjectManager.set(svg.objects);
        } catch (JAXBException e) {
            GraphicObjectManager.set(new ArrayList<>());
        }
        catch (Exception e) {
            return;
        }
    }

}
