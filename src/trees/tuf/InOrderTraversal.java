package trees.tuf;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public List<Integer> inorder(TreeNode root) {
        ArrayList<Integer> inOrderList = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode current = root;
        while (!nodeStack.isEmpty() || current != null) {
            while (current != null) {
                nodeStack.add(current);
                current = current.left;
            }
            current = nodeStack.pop();
            inOrderList.add(current.data);
            current = current.right;
        }
        return inOrderList;
    }
}
