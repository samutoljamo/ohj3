import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class ObjectNode extends Node implements Iterable<String> {
    private TreeMap<String, Node> _nodes;

    public ObjectNode() {
        _nodes = new TreeMap<>();
    }

    public void set(String key, Node node) {
        _nodes.put(key, node);
    }

    public Node get(String key) {
        return _nodes.get(key);
    }

    public int size() {
        return _nodes.size();
    }

    @Override
    public Iterator<String> iterator() {
        return _nodes.keySet().iterator();
    }
    
}
