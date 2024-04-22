package svgeditor.Utils.Serializers.Interface;

public interface ISerializer {
    public String serialize();

    public void deserialize(String text);
}
