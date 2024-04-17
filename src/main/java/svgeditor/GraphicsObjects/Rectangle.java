package svgeditor.GraphicsObjects;

import svgeditor.GraphicsObjects.Interfaces.IDrawable;

import java.awt.*;

public class Rectangle extends GraphicObject implements IDrawable {
    public double x1;
    public double x2;
    public double height;
    public double width;

    public Rectangle(double x1, double x2, double width, double height, String color){
        super(color, Rectangle.class);
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
