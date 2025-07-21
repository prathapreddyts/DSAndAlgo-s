package trees.tuf;

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