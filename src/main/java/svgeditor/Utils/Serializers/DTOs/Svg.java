package svgeditor.Utils.Serializers.DTOs;

import jakarta.xml.bind.annotation.*;
import svgeditor.GraphicsObjects.Ellipse;
import svgeditor.GraphicsObjects.GraphicObject;
import svgeditor.GraphicsObjects.Line;
import svgeditor.GraphicsObjects.Rectangle;
import svgeditor.Utils.GraphicObjectManager;

import jakarta.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "svg")
@XmlSeeAlso({Line.class, Rectangle.class, Ellipse.class})
public class Svg {
    public Svg(){

    }

    @XmlAttribute(name = "viewBox")
    public String viewBox = "0 0 1000 1000";

    @XmlElementWrapper(name = "g")
    @XmlAnyElement(lax=true)
    public List<GraphicObject> objects = new ArrayList<>();
}
