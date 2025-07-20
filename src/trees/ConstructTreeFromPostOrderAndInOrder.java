package trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ConstructTreeFromPostOrderAndInOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0) return null;

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        Stack<TreeNode> stack = new Stack<>();
        int postIndex = postorder.length - 1;
        TreeNode root = new TreeNode(postorder[postIndex--]);
        stack.push(root);

        for (int i = postIndex; i >= 0; i--) {
            TreeNode newNode = new TreeNode(postorder[i]);
            TreeNode node = stack.peek();

            if (inorderMap.get(newNode.data) > inorderMap.get(node.data)) {
                node.right = newNode;
            } else {
                while (!stack.isEmpty() && inorderMap.get(newNode.data) < inorderMap.get(stack.peek().data)) {
                    node = stack.pop();
                }
                node.left = newNode;
            }

            stack.push(newNode);
        }

        return root;
    }
}



