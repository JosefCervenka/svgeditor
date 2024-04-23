package svgeditor.GuiComponents.Buttons;

import svgeditor.Utils.DrawingTools.DrawingToolManager;
import svgeditor.Utils.DrawingTools.DrawingToolsEnum;

import javax.swing.*;

public class CreateMultiLineButton extends JButton {
    public CreateMultiLineButton() {
        super("Create Multi-line");

        this.addActionListener((event) -> {
            DrawingToolManager.isInitialized = false;
            DrawingToolManager.drawingTool = DrawingToolsEnum.MULTILINE;
        });
    }
}
