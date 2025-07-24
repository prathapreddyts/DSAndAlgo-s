package trees.learnyard.pathbasedproblems;

import trees.TreeNode;

import java.util.*;

public class LowestCommnonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        // Step 1: BFS to build parent map
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        parentMap.put(root, null);
        nodeQueue.add(root);

        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode current = nodeQueue.poll();
            if (current.left != null) {
                parentMap.put(current.left, current);
                nodeQueue.add(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                nodeQueue.add(current.right);
            }
        }

        // Step 2: Add all ancestors of p to a set
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }

        // Step 3: Walk up from q, the first match in ancestors is LCA
        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }

        return q; // this is the lowest common ancestor
    }
}
