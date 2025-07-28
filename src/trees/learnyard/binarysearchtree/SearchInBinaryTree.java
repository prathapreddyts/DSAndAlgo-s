package trees.learnyard.binarysearchtree;

import trees.TreeNode;

public class SearchInBinaryTree {
    public TreeNode searchBST(TreeNode root, int val) {
        return searchInBSTHelper(root, val);
    }

    private TreeNode searchInBSTHelper(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.data == val) {
            return root;
        }
        if (root.data > val) {
            return searchInBSTHelper(root.left, val);
        } else {
            return searchInBSTHelper(root.right, val);
        }

    }

    private TreeNode searchTargetIterativeWay(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null) {
            if (current.data == val) {
                return current;
            } else if (current.data > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }
}
