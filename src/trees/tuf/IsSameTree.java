package trees.tuf;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSameTree {
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

    public boolean isSameTreeIterativeWay(TreeNode pRoot, TreeNode qRoot) {
        if (pRoot == null && qRoot == null) return true;
        if (pRoot == null || qRoot == null) return false;

        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        pQueue.offer(pRoot);
        qQueue.offer(qRoot);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();

            // If data doesn't match, trees aren't the same
            if (pNode.data != qNode.data) {
                return false;
            }

            // Check left children
            if (pNode.left != null && qNode.left != null) {
                pQueue.offer(pNode.left);
                qQueue.offer(qNode.left);
            } else if (pNode.left != null || qNode.left != null) {
                return false;
            }

            // Check right children
            if (pNode.right != null && qNode.right != null) {
                pQueue.offer(pNode.right);
                qQueue.offer(qNode.right);
            } else if (pNode.right != null || qNode.right != null) {
                return false;
            }
        }

        // Both queues should be empty
        return pQueue.isEmpty() && qQueue.isEmpty();
    }

}
