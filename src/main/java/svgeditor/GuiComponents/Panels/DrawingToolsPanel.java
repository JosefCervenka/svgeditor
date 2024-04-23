package svgeditor.GuiComponents.Panels;

import svgeditor.GuiComponents.Buttons.CreateEllipseButton;
import svgeditor.GuiComponents.Buttons.CreateMultiLineButton;
import svgeditor.GuiComponents.Buttons.CreateRectangleButton;
import svgeditor.GuiComponents.Spinners.LineSizeSpinner;

import javax.swing.*;

public class DrawingToolsPanel extends JPanel {
    public DrawingToolsPanel() {
        add(new CreateMultiLineButton());
        add(new CreateEllipseButton());
        add(new CreateRectangleButton());
        add(new LineSizeSpinner());
    }
}
