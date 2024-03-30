package svgeditor.GuiComponents.Tables;

import svgeditor.Utils.ObjectManager;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class GraphicsObjectTable extends JTable {
    public GraphicsObjectTable(){
        super();

        setPreferredSize(new Dimension(200,  getMaximumSize().height));
    }
}
