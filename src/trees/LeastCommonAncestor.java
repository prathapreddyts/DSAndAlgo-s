package trees;

import java.util.*;

public class LeastCommonAncestor {
    public int lca(TreeNode root, int a, int b) {
        TreeNode lcaNode = lowestCommonAncestorHelper(root, findNode(root, a), findNode(root, b));
        return lcaNode.data;
    }

    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentMap = getParentMapBuild(root);
        Set<TreeNode> ancestors = new HashSet<>();

        // Step 1: Add all ancestors of p
        while (p != null) {
            ancestors.add(p);
            p = parentMap.get(p);
        }

        // Step 2: Traverse from q upwards until an ancestor of p is found
        while (!ancestors.contains(q)) {
            q = parentMap.get(q);
        }

        return q;
    }

    private Map<TreeNode, TreeNode> getParentMapBuild(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        parentMap.put(root, null);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }

        return parentMap;
    }
    private TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.data == val) {
                return current;
            }

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return null; // value not found in tree
    }
}
