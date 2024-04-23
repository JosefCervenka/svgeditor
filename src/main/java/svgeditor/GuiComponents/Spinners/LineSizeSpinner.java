package svgeditor.GuiComponents.Spinners;

import svgeditor.Utils.DrawingTools.DrawingToolManager;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LineSizeSpinner extends JSpinner {
    public LineSizeSpinner() {
        SpinnerModel spinnerModel = new SpinnerNumberModel(1.0, 1.0, 100.0, 1.0);
        this.setModel(spinnerModel);
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Double) {
            double newValue = (double) value;
            if (newValue >= 1.0 && newValue <= 100.0) {
                DrawingToolManager.lineSize = newValue;
            } else {
                throw new IllegalArgumentException("Line is not between 1 and 100.");
            }
        } else {
            throw new IllegalArgumentException("Invalid value type.");
        }
    }
}

