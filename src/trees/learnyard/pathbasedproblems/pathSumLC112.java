package trees.learnyard.pathbasedproblems;

import trees.TreeNode;

import java.util.*;

public class pathSumLC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<TreeNode> leafNodeList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        parentMap.put(root, null);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // If it's a leaf node
            if (current.left == null && current.right == null) {
                leafNodeList.add(current);
            }

            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }

            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }

        for (TreeNode leaf : leafNodeList) {
            int sum = 0;
            TreeNode current = leaf;
            while (current != null) {
                sum += current.data;
                current = parentMap.get(current);
            }

            if (sum == targetSum) {
                return true;
            }
        }

        return false;
    }

}
