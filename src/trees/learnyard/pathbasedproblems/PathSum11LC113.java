package trees.learnyard.pathbasedproblems;

import trees.TreeNode;

import java.util.*;

public class PathSum11LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Map<TreeNode, Integer> sumMap = new HashMap<>();

        queue.add(root);
        parentMap.put(root, null);
        sumMap.put(root, root.data);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentSum = sumMap.get(current);

            // If it's a leaf node and sum matches, trace the path
            if (current.left == null && current.right == null && currentSum == targetSum) {
                List<Integer> path = new LinkedList<>();
                TreeNode node = current;
                while (node != null) {
                    path.add(0, node.data); // reverse build
                    node = parentMap.get(node);
                }
                result.add(path);
            }

            // Process left child
            if (current.left != null) {
                parentMap.put(current.left, current);
                sumMap.put(current.left, currentSum + current.left.data);
                queue.add(current.left);
            }

            // Process right child
            if (current.right != null) {
                parentMap.put(current.right, current);
                sumMap.put(current.right, currentSum + current.right.data);
                queue.add(current.right);
            }
        }

        return result;
    }

}
