package svgeditor.GuiComponents.Panels;

import javax.swing.*;

public class XmlEditorPanel extends JPanel {

    public XmlEditorPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(java.awt.Color.LIGHT_GRAY);
        this.setPreferredSize(new java.awt.Dimension(200, 400));
        this.add(new JTextArea());
    }
}
