package svgeditor.GuiComponents.Tables;

import svgeditor.GraphicsObjects.Ellipse;
import svgeditor.GraphicsObjects.Line;
import svgeditor.GraphicsObjects.Rectangle;
import svgeditor.GuiComponents.TableModels.GraphicObjects.EllipseModel;
import svgeditor.GuiComponents.TableModels.GraphicObjects.LineModel;
import svgeditor.GuiComponents.TableModels.GraphicObjects.RectangleModel;
import svgeditor.Utils.ComponentsObserver;
import svgeditor.Utils.GraphicObjectManager;
import svgeditor.Utils.Interfaces.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class GraphicsObjectDetailTable extends JTable implements ISubscriber {
    public GraphicsObjectDetailTable() {
        setBackground(Color.lightGray);
        ComponentsObserver.addSubscriber(this);
    }

    public void update() {
        if (GraphicObjectManager.getSelectedObject() != null) {

            if(GraphicObjectManager.getSelectedObject() instanceof Ellipse){

                var ellipseModel = new EllipseModel();
                ellipseModel.setIndex(GraphicObjectManager.getIndexOfSelectedObject());
                this.setModel(ellipseModel);
            }

            if(GraphicObjectManager.getSelectedObject() instanceof Line){
                var lineModel = new LineModel();
                lineModel.setIndex(GraphicObjectManager.getIndexOfSelectedObject());
                this.setModel(lineModel);
            }

            if(GraphicObjectManager.getSelectedObject() instanceof Rectangle){
                var rectangleModel = new RectangleModel();
                rectangleModel.setIndex(GraphicObjectManager.getIndexOfSelectedObject());
                this.setModel(rectangleModel);
            }
        }
    }
}
