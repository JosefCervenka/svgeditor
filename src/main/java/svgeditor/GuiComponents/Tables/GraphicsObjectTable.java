package svgeditor.GuiComponents.Tables;

import svgeditor.GuiComponents.TableModels.GraphicObjectModel;
import svgeditor.Utils.ComponentsObserver;
import svgeditor.Utils.GraphicObjectManager;
import svgeditor.Utils.Interfaces.ISubscriber;

import javax.swing.*;
import java.awt.*;

public class GraphicsObjectTable extends JTable implements ISubscriber {
    public GraphicsObjectTable() {
        ComponentsObserver.addSubscriber(this);

        setBackground(Color.lightGray);

        this.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = this.getSelectedRow();

            if (selectedRow != -1)
                GraphicObjectManager.setSelectedObject(selectedRow);
        });
    }

    public void update() {
        this.setModel(new GraphicObjectModel());
        revalidate();
    }
}
