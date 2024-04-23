package svgeditor.GuiComponents.ColorPickers;

import svgeditor.Utils.DrawingTools.DrawingToolManager;

import javax.swing.*;
import java.awt.*;

public class StrokeColorSelector extends JTextField {
    public StrokeColorSelector() {
        super();


        setText(DrawingToolManager.strokeColor);

        this.addActionListener((event) -> {
            try {
                var color = ((String)this.getText()).toUpperCase();
                Color.decode(color);
            } catch (NumberFormatException e) {
                this.setText(DrawingToolManager.strokeColor);
                return;
            }

            DrawingToolManager.strokeColor = this.getText();
        });
    }


}
