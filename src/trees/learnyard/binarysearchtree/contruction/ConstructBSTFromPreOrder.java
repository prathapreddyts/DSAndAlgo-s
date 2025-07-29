package trees.learnyard.binarysearchtree.contruction;

import trees.TreeNode;

import java.util.Stack;

public class ConstructBSTFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode newNode = new TreeNode(preorder[i]);
            TreeNode parent = nodeStack.peek();
            if (newNode.data < parent.data) {
                parent.left = newNode;
            } else {
                while (!nodeStack.isEmpty() && nodeStack.peek().data < newNode.data) {
                    parent = nodeStack.pop();
                }
                parent.right = newNode;
            }
            nodeStack.push(newNode);
        }

        return root;
    }

}
