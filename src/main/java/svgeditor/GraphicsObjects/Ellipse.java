package svgeditor.GraphicsObjects;

import svgeditor.GraphicsObjects.Interfaces.IDrawable;

import java.awt.*;

public class Ellipse extends GraphicObject implements IDrawable {
    public double x1;
    public double x2;
    public double height;
    public double width;

    public Ellipse(double x1, double x2, double width, double height, String color){
        super(color, Ellipse.class);
        this.x1 = x1;
        this.x2 = x2;
        this.height = height;
        this.width = width;
    }
    public Ellipse(){

    }
    @Override
    public void Draw(Graphics2D graphics){
        if(graphics == null)
            return;

        graphics.setColor(Color.decode(this.color));
        graphics.setStroke(new BasicStroke((int)this.lineSize));
        graphics.drawOval((int) this.x1, (int) this.x2, (int) this.width, (int) this.height);
    }
}
