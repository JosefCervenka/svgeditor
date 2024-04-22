package svgeditor.GuiComponents.TextAreas;

import svgeditor.Utils.ComponentsObserver;
import svgeditor.Utils.Interfaces.ISubscriber;
import svgeditor.Utils.Serializers.XmlSerializer;

import java.awt.*;

public class XmlTextArea extends TextArea implements ISubscriber {

    private final XmlSerializer _xmlSerializer = new XmlSerializer();
    public XmlTextArea() {
        ComponentsObserver.addSubscriber(this);
    }

    @Override
    public void update() {
        this.setText(_xmlSerializer.serialize());
    }
}
