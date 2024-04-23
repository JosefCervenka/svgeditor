package svgeditor;

import svgeditor.GuiComponents.MainWindows;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            try {
                new MainWindows();
            } catch (Exception e) {
                System.out.println("GUI ERROR: "+e);
            }
        });


    }
}
