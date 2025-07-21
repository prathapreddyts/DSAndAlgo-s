package trees.tuf;

import java.util.HashMap;
import java.util.Stack;

public class ConstructTreeFromPreOrderAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        nodeStack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode newNode = new TreeNode(preorder[i]);
            TreeNode peekNode = nodeStack.peek();
            if (inOrderIndexMap.get(peekNode.data) > inOrderIndexMap.get(preorder[i])) {
                peekNode.left = newNode;
            } else {
                while (!nodeStack.isEmpty() &&
                        inOrderIndexMap.get(newNode.data) > inOrderIndexMap.get(nodeStack.peek().data)) {
                    peekNode = nodeStack.pop();
                }
                peekNode.right = newNode;
            }

            nodeStack.push(newNode);
        }
        return root;
    }

}

