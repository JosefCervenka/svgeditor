package svgeditor;

import svgeditor.GraphicsObjects.Ellipse;
import svgeditor.GraphicsObjects.GraphicObject;
import svgeditor.GraphicsObjects.Line;
import svgeditor.GraphicsObjects.Rectangle;
import svgeditor.GuiComponents.MainWindows;
import svgeditor.Utils.ComponentsObserver;
import svgeditor.Utils.GraphicObjectManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainWindows();
            } catch (Exception e) {
                System.out.println("GUI ERROR: "+e);
            }
        });


    }
}
