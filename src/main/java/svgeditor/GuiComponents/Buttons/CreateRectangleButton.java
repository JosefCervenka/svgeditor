package svgeditor.GuiComponents.Buttons;

import svgeditor.Utils.DrawingTools.DrawingToolManager;
import svgeditor.Utils.DrawingTools.DrawingToolsEnum;

import javax.swing.*;

public class CreateRectangleButton extends JButton {
    public CreateRectangleButton() {
        super("Create Rectangle");

        this.addActionListener((event) -> {
            DrawingToolManager.isInitialized = false;
            DrawingToolManager.drawingTool = DrawingToolsEnum.RECTANGLE;
        });
    }
}
