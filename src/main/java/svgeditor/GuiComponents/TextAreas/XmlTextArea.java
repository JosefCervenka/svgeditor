package svgeditor.GuiComponents.TextAreas;

import svgeditor.Utils.ComponentsObserver;
import svgeditor.Utils.Interfaces.ISubscriber;

import java.awt.*;

public class XmlTextArea extends TextArea implements ISubscriber {
    public XmlTextArea() {
        ComponentsObserver.addSubscriber(this);
    }

    @Override
    public void update() {

    }
}
