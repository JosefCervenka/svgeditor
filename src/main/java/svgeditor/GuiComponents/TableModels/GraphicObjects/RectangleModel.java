package svgeditor.GuiComponents.TableModels.GraphicObjects;

import svgeditor.GraphicsObjects.Rectangle;
import svgeditor.Utils.GraphicObjectManager;

import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class RectangleModel extends AbstractTableModel implements IIndex {
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
        var rectangle = (Rectangle) GraphicObjectManager.getSelectedObject();

        return switch (rowIndex) {
            case 0 -> columnIndex == 0 ? "x1" : rectangle.x1;
            case 1 -> columnIndex == 0 ? "x2" : rectangle.x2;
            case 2 -> columnIndex == 0 ? "width" : rectangle.width;
            case 3 -> columnIndex == 0 ? "height" : rectangle.height;
            case 4 -> columnIndex == 0 ? "line size" : rectangle.lineSize;
            case 5 -> columnIndex == 0 ? "color" : rectangle.color;
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        var rectangle = (Rectangle)GraphicObjectManager.getSelectedObject();

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
            case 0 -> rectangle.x1 = numberValue;
            case 1 -> rectangle.x2 = numberValue;
            case 2 -> rectangle.width = numberValue;
            case 3 -> rectangle.height = numberValue;
            case 4 -> rectangle.lineSize = numberValue;
            case 5 -> rectangle.color = (String)value;
        }
        GraphicObjectManager.updateSelectedObject(index, rectangle);
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
