package svgeditor.GraphicsObjects;

import svgeditor.GraphicsObjects.Interfaces.IDrawable;

import jakarta.xml.bind.annotation.*;
import java.awt.*;

@XmlRootElement(name = "line")
@XmlAccessorType(XmlAccessType.FIELD)
public class Line extends GraphicObject implements IDrawable {

    @XmlAttribute(name = "x1")
    public double x1;

    @XmlAttribute(name = "y1")
    public double y1;

    @XmlAttribute(name = "x2")
    public double x2;

    @XmlAttribute(name = "y2")
    public double y2;

    public Line(double x1, double x2, double y1, double y2, String color){
        super(color);
        this.x1 = x1;
        this.y1 = x2;
        this.x2 = y1;
        this.y2 = y2;
    }
    public Line(){

    }

    @Override
    public void Draw(Graphics2D graphics){
        if(graphics == null)
            return;

        graphics.setStroke(new BasicStroke((int)lineSize));
        graphics.setColor(Color.decode(color));
        graphics.drawLine((int)x1, (int) y1, (int) x2, (int)y2);
    }
}
