package trees.tuf;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> postOrderResult = new ArrayList<>();
        TreeNode current = root;
        TreeNode lastVisited = null;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (!nodeStack.isEmpty() || current != null) {
            if (current != null) {
                nodeStack.push(current);
                current = current.left;
            } else {
                TreeNode peekNode = nodeStack.peek();
                if (peekNode.right != null && peekNode.right != lastVisited) {
                    current = peekNode.right;
                } else {
                    postOrderResult.add(peekNode.data);
                    lastVisited = nodeStack.pop();
                }
            }

        }
        return postOrderResult;
    }
}
