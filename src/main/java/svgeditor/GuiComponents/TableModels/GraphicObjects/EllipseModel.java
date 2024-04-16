package svgeditor.GuiComponents.TableModels.GraphicObjects;

import svgeditor.GraphicsObjects.Ellipse;
import svgeditor.Utils.GraphicObjectManager;

import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class EllipseModel extends AbstractTableModel implements IIndex {
    @Override
    public int getRowCount() {
        return 6;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        var ellipse = (Ellipse)GraphicObjectManager.getSelectedObject();

        return switch (rowIndex) {
            case 0 -> columnIndex == 0 ? "x1" : ellipse.x1;
            case 1 -> columnIndex == 0 ? "x2" : ellipse.x2;
            case 2 -> columnIndex == 0 ? "width" : ellipse.width;
            case 3 -> columnIndex == 0 ? "height" : ellipse.height;
            case 4 -> columnIndex == 0 ? "line size" : ellipse.lineSize;
            case 5 -> columnIndex == 0 ? "color" : ellipse.color;
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        var ellipse = (Ellipse)GraphicObjectManager.getSelectedObject();

        double numberValue = 0;
        if(rowIndex != 5){
            try {
                numberValue = Double.parseDouble((String)value);
            } catch (NumberFormatException e) {
                return;
            }
        }

        if(rowIndex == 5){
            // Check if the color is valid
            try {
                var color = ((String)value).toUpperCase();
                Color.decode(color);
            } catch (NumberFormatException e) {
                return;
            }
        }

        switch (rowIndex) {
            case 0 -> ellipse.x1 = numberValue;
            case 1 -> ellipse.x2 = numberValue;
            case 2 -> ellipse.width = numberValue;
            case 3 -> ellipse.height = numberValue;
            case 4 -> ellipse.lineSize = numberValue;
            case 5 -> ellipse.color = (String)value;
        }

        GraphicObjectManager.updateSelectedObject(index, ellipse);
    }

    private int index = 0;

    @Override
    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int getIndex() {
        return index;
    }
}
