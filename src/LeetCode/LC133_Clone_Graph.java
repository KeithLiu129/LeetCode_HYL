package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC133_Clone_Graph {
    private HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return node;

        if (map.containsKey(node)) return map.get(node);

        Node cloneNode = new Node(node.val, new ArrayList<>());

        map.put(node, cloneNode);

        for (Node neighbor : node.children) {
            cloneNode.children.add(cloneGraph(neighbor));
        }
        return cloneNode;
        }
}
