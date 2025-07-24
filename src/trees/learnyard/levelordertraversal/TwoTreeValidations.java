package trees.learnyard.levelordertraversal;

import trees.TreeNode;

public class TwoTreeValidations {
    public boolean isSameTree(TreeNode pRoot, TreeNode qRoot) {
        if (pRoot == null && qRoot == null) {
            return true;
        }
        if ((pRoot != null && qRoot == null) || (pRoot == null && qRoot == null)) {
            return false;
        }
        if (pRoot.data != qRoot.data) {
            return false;
        }
        return isSameTree(pRoot.left, qRoot.left) && isSameTree(pRoot.right, qRoot.right);

    }
}
