package svgeditor.GraphicsObjects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;
import svgeditor.GraphicsObjects.Interfaces.IDrawable;

import jakarta.xml.bind.annotation.*;
import java.lang.reflect.Type;

@XmlAccessorType(XmlAccessType.FIELD)
public abstract class GraphicObject implements IDrawable {


    @XmlAttribute(name = "stroke-width")
    public double lineSize = 1;

    @XmlAttribute(name = "fill")
    public String fill = "none";

    @XmlAttribute(name = "stroke")
    public String color;

    GraphicObject(String color){
        this.color = color;
    }

    GraphicObject(){

    }
}
