package svgeditor.GuiComponents.TableModels.GraphicObjects;

import svgeditor.GraphicsObjects.Line;
import svgeditor.Utils.GraphicObjectManager;

import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class LineModel extends AbstractTableModel implements IIndex {
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
        var line = (Line) GraphicObjectManager.getSelectedObject();

        return switch (rowIndex) {
            case 0 -> columnIndex == 0 ? "x1" : line.x1;
            case 1 -> columnIndex == 0 ? "x2" : line.y1;
            case 2 -> columnIndex == 0 ? "y1" : line.x2;
            case 3 -> columnIndex == 0 ? "y2" : line.y2;
            case 4 -> columnIndex == 0 ? "line size" : line.lineSize;
            case 5 -> columnIndex == 0 ? "color" : line.color;
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        var line = (Line)GraphicObjectManager.getSelectedObject();

        double numberValue = 0;
        if(rowIndex != 5){
            try {
                numberValue = Double.parseDouble((String)value);
            } catch (NumberFormatException e) {
                return;
            }
        }

        if(rowIndex == 5){
            try {
                var color = ((String)value).toUpperCase();
                Color.decode(color);
            } catch (NumberFormatException e) {
                return;
            }
        }

        switch (rowIndex) {
            case 0 -> line.x1 = numberValue;
            case 1 -> line.y1 = numberValue;
            case 2 -> line.x2 = numberValue;
            case 3 -> line.y2 = numberValue;
            case 4 -> line.lineSize = numberValue;
            case 5 -> line.color = ((String)value).toUpperCase();
        }
        GraphicObjectManager.updateSelectedObject(getIndex(), line);
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
