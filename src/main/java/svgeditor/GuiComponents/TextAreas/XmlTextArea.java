package svgeditor.GuiComponents.TextAreas;

import svgeditor.Utils.ComponentsObserver;
import svgeditor.Utils.Interfaces.ISubscriber;
import svgeditor.Utils.Serializers.XmlSerializer;

import java.awt.*;
import java.awt.event.*;

public class XmlTextArea extends TextArea implements ISubscriber {
    String xml = "";
    private final XmlSerializer _xmlSerializer = new XmlSerializer();
    public XmlTextArea() {
        ComponentsObserver.addSubscriber(this);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    _xmlSerializer.deserialize(xml);
                }
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    _xmlSerializer.deserialize(xml);
                }
            }
        });

        this.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {

                _xmlSerializer.deserialize(xml);
            }
        });

        this.addTextListener((event) -> {
            xml = this.getText();
        });
    }

    @Override
    public void update() {
        this.setText(_xmlSerializer.serialize());
    }
}
