package trees.tuf;

import trees.TreeNode;

public class CountTotalNodesInBT {
    int[] dp = new int[1];
    public int countNodes(TreeNode root) {
        return countNodesHelper(root, dp);

    }

    private int countNodesHelper(TreeNode root, int[] dp) {
        if (root == null) {
            return 0;
        }
        int left = countNodesHelper(root.left, dp);
        int right = countNodesHelper(root.right, dp);

        dp[0] = left + right;
        return dp[0] + 1;
    }
}
