package svgeditor.Utils.Serializers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import svgeditor.Utils.GraphicObjectManager;
import svgeditor.Utils.Serializers.DTOs.Svg;
import svgeditor.Utils.Serializers.Interface.ISerializer;

public class JsonSerializer implements ISerializer {

    private final GsonBuilder _builder = new GsonBuilder();
    private Svg svg = new Svg();
    @Override
    public String serialize() {
        if(GraphicObjectManager.getAll() != null) {
            svg.objects = GraphicObjectManager.getAll();
        }
        Gson gson = _builder.create();
        return gson.toJson(svg);
    }

    @Override
    public void deserialize(String text) {
        //nope
    }
}
