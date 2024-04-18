package svgeditor.GraphicsObjects;

import svgeditor.GraphicsObjects.Interfaces.IDrawable;

import jakarta.xml.bind.annotation.*;
import java.awt.*;

@XmlRootElement(name = "ellipse")
@XmlAccessorType(XmlAccessType.FIELD)
public class Ellipse extends GraphicObject implements IDrawable {

    @XmlAttribute(name = "x")
    public double x1;

    @XmlAttribute(name = "y")
    public double x2;

    @XmlAttribute(name = "height")
    public double height;

    @XmlAttribute(name = "width")
    public double width;

    public Ellipse(double x1, double x2, double width, double height, String color) {
        super(color);
        this.x1 = x1;
        this.x2 = x2;
        this.height = height;
        this.width = width;
    }

    public Ellipse() {

    }

    @Override
    public void Draw(Graphics2D graphics) {
        if (graphics == null)
            return;

        graphics.setColor(Color.decode(this.color));
        graphics.setStroke(new BasicStroke((int) this.lineSize));
        graphics.drawOval((int) this.x1, (int) this.x2, (int) this.width, (int) this.height);
    }
}
