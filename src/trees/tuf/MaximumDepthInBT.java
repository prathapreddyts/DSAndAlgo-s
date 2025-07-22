package trees.tuf;

import trees.TreeNode;

import java.util.*;

public class MaximumDepthInBT {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public int maxDepthParentMapWay(TreeNode root) {
        Map<TreeNode, Integer> depthMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        depthMap.put(root, 1);
        queue.offer(root);

        int maxDepth = 1;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentDepth = depthMap.get(current);

            if (current.left != null) {
                queue.offer(current.left);
                depthMap.put(current.left, currentDepth + 1);
                maxDepth = Math.max(maxDepth, currentDepth + 1);
            }

            if (current.right != null) {
                queue.offer(current.right);
                depthMap.put(current.right, currentDepth + 1);
                maxDepth = Math.max(maxDepth, currentDepth + 1);
            }
        }

        return maxDepth;
    }
}
