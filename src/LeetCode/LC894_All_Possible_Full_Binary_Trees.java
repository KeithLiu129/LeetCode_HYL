package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * ${A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 *
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
 *
 * Each node of each tree in the answer must have node.val = 0.
 *
 * You may return the final list of trees in any order.}
 *
 * @author KeithLiu on 2020-03-28
 */

public class LC894_All_Possible_Full_Binary_Trees {
        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        public List<TreeNode> allPossibleFBT(int N) {
            if (map.containsKey(N)) {
                return map.get(N);
            }
            if (N % 2 == 0) {
                return new ArrayList<>();
            }
            List<TreeNode> res = new ArrayList<>();
            if (N == 1) {
                res.add(new TreeNode(0));
            }else {
                for (int i = 2; i <= N; i = i + 2) {
                    List<TreeNode> leftSubtree = allPossibleFBT(i - 1);
                    List<TreeNode> rightSubtree = allPossibleFBT(N - i);
                    for (TreeNode left : leftSubtree) {
                        for (TreeNode right : rightSubtree) {
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            res.add(root);
                        }
                    }
                }
            }
            map.put(N, res);
            return res;
        }
    }
