package trees.learnyard.binarysearchtree;

import trees.TreeNode;

public class InsertInToBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);

        // Base case: if tree is empty
        if (root == null) {
            return newNode;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;
            if (val < current.data) {
                current = current.left;
            } else if (val > current.data) {
                current = current.right;
            } else {
                return root;
            }
        }
        // Insert the new node at the correct position
        if (val < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        return root;
    }

}
