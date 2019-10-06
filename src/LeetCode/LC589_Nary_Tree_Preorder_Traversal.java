package LeetCode;

//589. N-ary Tree Preorder Traversal
//https://leetcode.com/problems/n-ary-tree-preorder-traversal/

import java.util.LinkedList;
import java.util.List;

public class LC589_Nary_Tree_Preorder_Traversal {
    public List<Integer> preorder(Node root) {
        //recursion
        /*
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;

        res.add(root.val);
        for(int i = 0; i < root.children.size(); i++) {
            res.addAll(preorder(root.children.get(i)));
        }

        return res;
        */
        List<Integer> res = new LinkedList<>();
        if(root == null) return res;

        LinkedList<Node> stack = new LinkedList<>();
        stack.offerFirst(root);

        while(!stack.isEmpty()) {
            Node tmp = stack.pollFirst();
            res.add(tmp.val);
            int size = tmp.children.size();
            while(size-- > 0) {
                stack.offerFirst(tmp.children.get(size));
            }
        }
        return res;
    }
}
