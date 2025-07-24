package trees.learnyard.pathbasedproblems;

import trees.TreeNode;


import java.util.*;

public class SumRootToLeafNumberLC129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        List<TreeNode> leafNodes = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        nodeQueue.add(root);
        parentMap.put(root, null);

        // BFS traversal to build parent map and track leaf nodes
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            if (current.left == null && current.right == null) {
                leafNodes.add(current);
            }
            if (current.left != null) {
                parentMap.put(current.left, current);
                nodeQueue.add(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                nodeQueue.add(current.right);
            }
        }

        // Calculate the total sum
        int totalSum = 0;
        for (TreeNode leaf : leafNodes) {
            List<Integer> digits = new ArrayList<>();
            TreeNode current = leaf;
            while (current != null) {
                digits.add(current.data); // store digits
                current = parentMap.get(current);
            }
            // build number from root to leaf
            int num = 0;
            for (int i = digits.size() - 1; i >= 0; i--) {
                num = num * 10 + digits.get(i);
            }
            totalSum += num;
        }

        return totalSum;
    }

}
