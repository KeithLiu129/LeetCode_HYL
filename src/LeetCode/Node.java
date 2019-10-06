package LeetCode;

import java.util.List;

public class Node {
    int val;
    List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
