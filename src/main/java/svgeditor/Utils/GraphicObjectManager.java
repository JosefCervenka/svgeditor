package svgeditor.Utils;

import svgeditor.GraphicsObjects.GraphicObject;
import java.util.ArrayList;
import java.util.List;

public class GraphicObjectManager {

    private static GraphicObject selectedObject = null;

    public static GraphicObject getSelectedObject() {
        return selectedObject;
    }

    public static void updateSelectedObject(int index, GraphicObject graphicObject){
        selectedObject = graphicObject;

        update(index, graphicObject);
    }

    private static int index = 0;

    public static int getIndexOfSelectedObject() {
        return index;
    }

    public static void setSelectedObject(int index){
        selectedObject = graphicObjects.get(index);
        GraphicObjectManager.index = index;
        ComponentsObserver.update();
    }

    private static List<GraphicObject> graphicObjects = new ArrayList<GraphicObject>();

    public static void set(List<GraphicObject> graphicObjectList) {
        graphicObjects = graphicObjectList;
        if(!graphicObjects.isEmpty()) {
            selectedObject = graphicObjects.getFirst();
        }
        ComponentsObserver.update();
    }
    public static List<GraphicObject> getAll() {
        return graphicObjects;
    }
    public static void add(GraphicObject graphicObject) {
        graphicObjects.add(graphicObject);
        ComponentsObserver.update();
    }

    public static void remove(GraphicObject graphicObject) {
        graphicObjects.remove(graphicObject);
        ComponentsObserver.update();
    }

    public static void update(int index, GraphicObject graphicObject) {
        graphicObjects.set(index,graphicObject);
        ComponentsObserver.update();
    }

    public static GraphicObject get(int index) {
        return graphicObjects.get(index);
    }
}
