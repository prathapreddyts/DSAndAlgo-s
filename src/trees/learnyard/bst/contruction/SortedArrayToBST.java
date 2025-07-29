package trees.learnyard.bst.contruction;

import trees.TreeNode;

import java.util.Stack;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int mid = (nums.length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, nums.length - 1, root));

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            int low = current.low;
            int high = current.high;
            int currMid = (low + high) / 2;

            if (currMid - 1 >= low) {
                int leftMid = (low + currMid - 1) / 2;
                TreeNode leftNode = new TreeNode(nums[leftMid]);
                current.rootNode.left = leftNode;
                stack.push(new Node(low, currMid - 1, leftNode));
            }

            if (currMid + 1 <= high) {
                int rightMid = (currMid + 1 + high) / 2;
                TreeNode rightNode = new TreeNode(nums[rightMid]);
                current.rootNode.right = rightNode;
                stack.push(new Node(currMid + 1, high, rightNode));
            }
        }

        return root;
    }
}

class Node {
    int low, high;
    TreeNode rootNode;

    Node(int low, int high, TreeNode rootNode) {
        this.low = low;
        this.high = high;
        this.rootNode = rootNode;
    }
}

