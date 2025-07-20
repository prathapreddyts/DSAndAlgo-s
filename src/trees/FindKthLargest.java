package trees;


import java.util.Stack;

public class FindKthLargest {
    public int kthSmallest(TreeNode root, int k) {
        return findKthLargest(root, k);
    }

    private int findKthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }
            current = stack.pop();
            k--;
            if (k == 0) {
                return current.data;
            }
            current = current.left;
        }
        return -1;
    }
}
