package svgeditor.GuiComponents.Panels;

import svgeditor.Utils.ObjectManager;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        ObjectManager.init((Graphics2D) graphics, this);
        ObjectManager.drawAll();
    }

}
