package trees.learnyard.binarysearchtree.contruction;

import trees.TreeNode;

import java.util.*;

public class BalancedBinaryTree {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        return buildBalancedBST(inorderList, 0, inorderList.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }

    private TreeNode buildBalancedBST(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBalancedBST(list, start, mid - 1);
        node.right = buildBalancedBST(list, mid + 1, end);
        return node;
    }

    // Optional: Reconstruct BST from preorder
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = stack.peek();
            if (node.data < parent.data) {
                parent.left = node;
            } else {
                while (!stack.isEmpty() && stack.peek().data < node.data) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }

    // Optional: Reconstruct BST from postorder
    public TreeNode bstFromPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = postorder.length - 2; i >= 0; i--) {
            TreeNode node = new TreeNode(postorder[i]);
            TreeNode parent = null;
            while (!stack.isEmpty() && node.data < stack.peek().data) {
                parent = stack.pop();
            }
            if (parent != null) {
                parent.left = node;
            } else {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
