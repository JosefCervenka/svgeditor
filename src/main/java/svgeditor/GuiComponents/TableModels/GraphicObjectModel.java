package svgeditor.GuiComponents.TableModels;

import svgeditor.Utils.GraphicObjectManager;

import javax.swing.table.AbstractTableModel;
import java.util.Arrays;

public class GraphicObjectModel extends AbstractTableModel {

    public GraphicObjectModel (){
        super();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }
    @Override
    public int getRowCount() {
        return GraphicObjectManager.getAll().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return switch (columnIndex) {
            case 0 -> rowIndex + 1;
            case 1 -> Arrays.stream(GraphicObjectManager.getAll().get(rowIndex).type.getTypeName().split("\\.")).toList().getLast();
            default -> null;
        };
    }
    String[] columnNames = {"Id", "Type"};
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }


    @Override
    public void setValueAt(Object value, int row, int column) {
        System.out.println(value);
    }
}
