package LeetCode;

//590. N-ary Tree Postorder Traversal
//https://leetcode.com/problems/n-ary-tree-postorder-traversal/

import java.util.LinkedList;
import java.util.List;

public class LC590_Nary_Tree_Postorder_Traversal {
    public List<Integer> postorder(Node root) {
        //recursion
        /*
        List<Integer> res = new LinkedList<>();

        if(root == null) return res;

        int size = root.children.size();
        for(int i = 0; i < size; i++) {
            res.addAll(postorder(root.children.get(i)));
        }
        res.add(root.val);

        return res;
        */

        //iterative
        LinkedList<Integer> res = new LinkedList<>();

        if(root == null) return res;

        LinkedList<Node> stack = new LinkedList<>();
        stack.offerFirst(root);

        while(!stack.isEmpty()) {
            Node tmp = stack.pollFirst();
            res.addFirst(tmp.val);
            for(Node n : tmp.children) {
                stack.offerFirst(n);
            }
        }
        return res;


    }
}
