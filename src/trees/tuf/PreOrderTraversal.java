package trees.tuf;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode current = root;
        nodeStack.push(current);
        while (!nodeStack.isEmpty()) {
            current = nodeStack.pop();
            preOrderList.add(current.data);
            if (current.right != null) {
                nodeStack.add(current.right);
            }
            if (current.left != null) {
                nodeStack.add(current.left);
            }
        }
        return preOrderList;
    }
}
