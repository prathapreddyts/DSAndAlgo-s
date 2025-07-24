package trees.learnyard.levelordertraversal;

import trees.TreeNode;

import java.util.*;

public class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Map<Integer, Integer> depthMap = new HashMap<>();
        Map<Integer, TreeNode> parentMap = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        depthMap.put(root.data, 0);
        parentMap.put(root.data, null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
                depthMap.put(node.left.data, depthMap.get(node.data) + 1);
                parentMap.put(node.left.data, node);
            }

            if (node.right != null) {
                queue.offer(node.right);
                depthMap.put(node.right.data, depthMap.get(node.data) + 1);
                parentMap.put(node.right.data, node);
            }
        }

        return depthMap.get(x).equals(depthMap.get(y)) &&
                parentMap.get(x) != parentMap.get(y);
    }

}
