package svgeditor.GuiComponents.Panels;

import svgeditor.GuiComponents.TableModels.GraphicObjectModel;
import svgeditor.GuiComponents.Tables.GraphicsObjectDetailTable;
import svgeditor.GuiComponents.Tables.GraphicsObjectTable;

import javax.swing.*;
import java.awt.*;

public class ObjectManagerPanel extends JPanel {

    public ObjectManagerPanel() {
        this.setLayout(new GridLayout(2, 1));

        add(new GraphicsObjectTable());
        add(new GraphicsObjectDetailTable());
    }
}
