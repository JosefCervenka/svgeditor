package svgeditor.GraphicsObjects;

import svgeditor.GraphicsObjects.Interfaces.IDrawable;

import java.lang.reflect.Type;

public abstract class GraphicObject implements IDrawable {
    public Type type;
    public double lineSize = 1;
    public String color;
    GraphicObject(String color, Type type){
        this.type = type;
        this.color = color;
    }
    GraphicObject(){

    }
}
