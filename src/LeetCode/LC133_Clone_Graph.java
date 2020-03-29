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
//class Solution {
//    public Node cloneGraph(Node node) {
//        if (node == null) return node;
//
//// Pop a node from the front of the queue.
//// Visit all the neighbors of this node.
//// If any of the neighbors was already visited then it must be present in the visited dictionary. Get the clone of this neighbor from visited in that case.
//// Otherwise, create a clone and store in the visited.
//// Add the clones of the neighbors to the corresponding list of the clone node.
//        HashMap<Node, Node> map = new HashMap<Node, Node>();
//        Queue<Node> q = new LinkedList<>();
//        map.put(node, new Node(node.val));
//        q.offer(node);
//        while(!q.isEmpty()) {
//            Node cur = q.poll();
//            for(Node next : cur.neighbors) {
//                if (!map.containsKey(next)) {
//                    map.put(next, new Node(next.val));
//                    q.offer(next);
//                }
//                map.get(cur).neighbors.add(map.get(next));
//            }
//        }
//
//        return map.get(node);
//    }
//}



