package trees.learnyard.binarysearchtree.contruction;

import trees.TreeNode;

import java.util.Stack;

public class ConstructBSTFromPostOrder {
    public TreeNode constructTree(int[] postOrder) {
        if (postOrder == null || postOrder.length == 0) {
            return null;
        }

        int len = postOrder.length;
        TreeNode root = new TreeNode(postOrder[len - 1]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        for (int i = len - 2; i >= 0; i--) {
            TreeNode newNode = new TreeNode(postOrder[i]);

            if (newNode.data > stack.peek().data) {
                stack.peek().right = newNode;
            } else {
                while (!stack.isEmpty() && newNode.data < stack.peek().data) {
                    root = stack.pop();
                }
                root.left = newNode;
            }
            stack.push(newNode);
        }
        return root;
    }


}
