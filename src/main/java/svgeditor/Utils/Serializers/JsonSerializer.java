package svgeditor.Utils.Serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import svgeditor.GraphicsObjects.GraphicObject;
import svgeditor.Utils.Serializers.Adapters.JsonAdapter;
import svgeditor.Utils.Serializers.Interfaces.ISerializer;

import java.util.ArrayList;
import java.util.List;

public class JsonSerializer implements ISerializer {
    Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(GraphicObject.class, new JsonAdapter())
            .setPrettyPrinting()
            .create();
    @Override
    public String serialize(List<GraphicObject> graphicObjects) {
        return gson.toJson(graphicObjects);
    }
    public List<GraphicObject> deserialize(String text){

        JsonAdapter jsonAdapter = new JsonAdapter();

        return jsonAdapter.deserializeHashMap(gson.fromJson(text, new ArrayList<GraphicObject>().getClass()));
    }
}
