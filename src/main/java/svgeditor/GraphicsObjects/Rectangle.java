package svgeditor.GraphicsObjects;

import svgeditor.GraphicsObjects.Interfaces.IDrawable;

import jakarta.xml.bind.annotation.*;
import java.awt.*;

@XmlRootElement(name = "rect")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rectangle extends GraphicObject implements IDrawable {

    @XmlAttribute(name = "x")
    public double x1;

    @XmlAttribute(name = "y")
    public double x2;

    @XmlAttribute(name = "height")
    public double height;

    @XmlAttribute(name = "width")
    public double width;

    public Rectangle(double x1, double x2, double width, double height, String color){
        super(color);
        this.x1 = x1;
        this.x2 = x2;
        this.width = width;
        this.height = height;
    }
    public Rectangle(){

    }

    @Override
    public void Draw(Graphics2D graphics){
        if(graphics == null)
            return;

        graphics.setStroke(new BasicStroke((int)lineSize));
        graphics.setColor(Color.decode(color));
        graphics.drawRect((int) this.x1, (int) this.x2, (int) this.width, (int) this.height);
    }
}
