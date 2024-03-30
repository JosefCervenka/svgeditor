package svgeditor.GuiComponents.Panels;

import svgeditor.GuiComponents.Tables.GraphicsObjectTable;
import svgeditor.Utils.ObjectManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

public class ObjectManagerPanel extends JPanel {
    public ObjectManagerPanel(){
        setBackground(Color.LIGHT_GRAY);
        GraphicsObjectTable table = new GraphicsObjectTable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        add(scrollPane);
        ObjectManager.setGraphicsObjectTable(table);
    }
}
