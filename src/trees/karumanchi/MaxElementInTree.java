package trees.karumanchi;

import trees.TreeNode;

import java.util.Stack;

public class MaxElementInTree {
    public int maxValue = Integer.MIN_VALUE;

    public int maxValueInTree(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = maxValueInTree(root.left);
        int right = maxValueInTree(root.right);


        return Math.max(root.data, Math.max(left, right));
    }

    public int maxValueUsingIterativeWay(TreeNode root) {
        Integer maxValue = Integer.MIN_VALUE;
        TreeNode current = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
            TreeNode poppedNode = nodeStack.pop();
            maxValue = Math.max(maxValue, poppedNode.data);
            current = poppedNode.right;
        }
        return maxValue;
    }

}
