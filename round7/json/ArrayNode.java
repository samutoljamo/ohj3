import java.util.ArrayList;
import java.util.Iterator;

public class ArrayNode extends Node implements Iterable<Node> {

    private ArrayList<Node> _nodes;

    public ArrayNode() {
        _nodes = new ArrayList<>();
    }

    public void add(Node node) {
        _nodes.add(node);
    }

    public int size() {
        return _nodes.size();
    }

    

    @Override
    public Iterator<Node> iterator() {
        return _nodes.iterator();
    }
}
