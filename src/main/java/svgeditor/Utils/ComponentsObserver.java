package svgeditor.Utils;

import svgeditor.Utils.Interfaces.ISubscriber;

import java.util.ArrayList;
import java.util.List;

public class ComponentsObserver {
    private final static List<ISubscriber> subscribers = new ArrayList<ISubscriber>();
    public static void addSubscriber(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }
    public static void update() {
        for (ISubscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}
