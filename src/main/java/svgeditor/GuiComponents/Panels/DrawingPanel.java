package svgeditor.GuiComponents.Panels;

import svgeditor.Utils.ComponentsObserver;
import svgeditor.Utils.Interfaces.ISubscriber;
import svgeditor.Utils.GraphicObjectManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel implements ISubscriber {
    private Graphics _graphics;
    public DrawingPanel () {
        setBackground(Color.white);
        ComponentsObserver.addSubscriber(this);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getX());
            }
        });
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        this._graphics = graphics;
        drawAll();
    }

    private void drawAll() {

        for (var item : GraphicObjectManager.getAll()) {
            item.Draw((Graphics2D)this._graphics);
        }
        repaint();
    }

    @Override
    public void update() {
        drawAll();
    }
}
