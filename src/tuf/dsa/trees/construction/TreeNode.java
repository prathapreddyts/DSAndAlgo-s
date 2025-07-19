package tuf.dsa.trees.construction;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        int data = val;
        left = null;
        right = null;
    }
}