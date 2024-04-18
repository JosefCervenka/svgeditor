package svgeditor.GuiComponents.Panels;

import svgeditor.GuiComponents.TextAreas.XmlTextArea;
import svgeditor.Utils.Serializers.XmlSerializer;

import javax.swing.*;
import java.awt.*;

public class XmlEditorPanel extends JPanel {

    public XmlEditorPanel() {
        this.setLayout(new GridLayout(2, 1));
        this.setPreferredSize(new Dimension(400, 600));

        var xmlTextArea = new XmlTextArea();
        this.setBackground(java.awt.Color.LIGHT_GRAY);
        this.add(xmlTextArea);

        XmlSerializer xmlSerializer = new XmlSerializer();
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            xmlSerializer.Deserialize(xmlTextArea.getText());
        });

        add(saveButton);
    }
}
