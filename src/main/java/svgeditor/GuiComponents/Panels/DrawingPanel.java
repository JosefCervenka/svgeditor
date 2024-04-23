package svgeditor.GuiComponents.Panels;

import svgeditor.GraphicsObjects.Ellipse;
import svgeditor.GraphicsObjects.Rectangle;
import svgeditor.Utils.ComponentsObserver;
import svgeditor.Utils.DrawingTools.DrawingToolManager;
import svgeditor.Utils.DrawingTools.DrawingToolsEnum;
import svgeditor.Utils.Interfaces.ISubscriber;
import svgeditor.Utils.GraphicObjectManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel implements ISubscriber {
    private Graphics _graphics;
    public DrawingPanel () {
        setBackground(Color.white);
        ComponentsObserver.addSubscriber(this);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if(DrawingToolManager.drawingTool == DrawingToolsEnum.UNDEFINED)
                    return;

                if(DrawingToolManager.drawingTool == DrawingToolsEnum.ELLIPSE){
                    if(DrawingToolManager.isInitialized){
                        DrawingToolManager.end1 = e.getX();
                        DrawingToolManager.end2 = e.getY();
                        DrawingToolManager.isInitialized = false;

                        var ellipse = createEllipse();
                        ellipse.lineSize = 1;
                        GraphicObjectManager.add(ellipse);
                    }
                }

                if(DrawingToolManager.drawingTool == DrawingToolsEnum.RECTANGLE){
                    if(DrawingToolManager.isInitialized){
                        DrawingToolManager.end1 = e.getX();
                        DrawingToolManager.end2 = e.getY();
                        DrawingToolManager.isInitialized = false;

                        var rectangle = createRectangle();
                        rectangle.lineSize = 1;
                        GraphicObjectManager.add(rectangle);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(DrawingToolManager.drawingTool == DrawingToolsEnum.UNDEFINED)
                    return;
                if(DrawingToolManager.drawingTool == DrawingToolsEnum.ELLIPSE){
                    if(!DrawingToolManager.isInitialized){
                        DrawingToolManager.start1 = e.getX();
                        DrawingToolManager.start2 = e.getY();
                        DrawingToolManager.isInitialized = true;
                    }
                }

                if(DrawingToolManager.drawingTool == DrawingToolsEnum.RECTANGLE){
                    if(!DrawingToolManager.isInitialized){
                        DrawingToolManager.start1 = e.getX();
                        DrawingToolManager.start2 = e.getY();
                        DrawingToolManager.isInitialized = true;
                    }
                }
            }
        });
    }


    private static Rectangle createRectangle(){
        double startX = DrawingToolManager.start1;
        double endX = DrawingToolManager.end1;
        double startY = DrawingToolManager.start2;
        double endY = DrawingToolManager.end2;

        if (DrawingToolManager.start1 > DrawingToolManager.end1) {
            startX = DrawingToolManager.end1;
            endX = DrawingToolManager.start1;
        }
        if (DrawingToolManager.start2 > DrawingToolManager.end2) {
            startY = DrawingToolManager.end2;
            endY = DrawingToolManager.start2;
        }

        double distanceX = Math.abs(endX - startX);
        double distanceY = Math.abs(endY - startY);

        var rectangle = new Rectangle(startX, startY, distanceX, distanceY, "#000000");
        return rectangle;
    }
    private static Ellipse createEllipse() {
        double startX = DrawingToolManager.start1;
        double endX = DrawingToolManager.end1;
        double startY = DrawingToolManager.start2;
        double endY = DrawingToolManager.end2;

        if (DrawingToolManager.start1 > DrawingToolManager.end1) {
            startX = DrawingToolManager.end1;
            endX = DrawingToolManager.start1;
        }
        if (DrawingToolManager.start2 > DrawingToolManager.end2) {
            startY = DrawingToolManager.end2;
            endY = DrawingToolManager.start2;
        }

        double distanceX = Math.abs(endX - startX);
        double distanceY = Math.abs(endY - startY);

        var ellipse = new Ellipse(startX, startY, distanceX, distanceY, "#000000");
        return ellipse;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this._graphics = graphics;
        drawAll();
    }

    private void drawAll() {

        for (var item : GraphicObjectManager.getAll()) {
            item.Draw((Graphics2D)this._graphics);
        }
        repaint();
    }

    @Override
    public void update() {
        drawAll();
    }
}
