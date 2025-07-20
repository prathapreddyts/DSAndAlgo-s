package trees;

import java.util.Stack;

public class KthSmallestNode {
    public int kthSmallest(TreeNode root, int k) {
        return findKthSmallest(root, k);
    }

    private int findKthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            k--;
            if (k == 0) return current.data;

            current = current.right;
        }

        return -1; // k is out of range
    }
}
