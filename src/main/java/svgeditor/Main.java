package svgeditor;

import svgeditor.GuiComponents.MainWindows;
import svgeditor.Utils.ObjectManager;
import svgeditor.Utils.Serializers.Interfaces.ISerializer;
import svgeditor.Utils.Serializers.JsonSerializer;
import svgeditor.Utils.Serializers.XmlSerializer;

import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");
        SwingUtilities.invokeLater(() -> {
            try {
                var main = new MainWindows();
            } catch (Exception e) {
                System.out.println("GUI ERROR: "+e);
            }
        });

        ISerializer xmlSerializer = new XmlSerializer();
        ISerializer jsonSerializer = new JsonSerializer();

        var xml = xmlSerializer.serialize(ObjectManager.graphicObjects);
        var xmlBack = xmlSerializer.deserialize(xml);

        var json = jsonSerializer.serialize(ObjectManager.graphicObjects);
        var jsonBack = jsonSerializer.deserialize(json);


    }
}
