package svgeditor.GuiComponents.Buttons;

import svgeditor.Utils.DrawingTools.DrawingToolManager;
import svgeditor.Utils.DrawingTools.DrawingToolsEnum;

import javax.swing.*;

public class CreateEllipseButton extends JButton {
    public CreateEllipseButton() {
        super("Create Ellipse");

        this.addActionListener((event) -> {
            DrawingToolManager.isInitialized = false;
            DrawingToolManager.drawingTool = DrawingToolsEnum.ELLIPSE;
        });
    }
}
