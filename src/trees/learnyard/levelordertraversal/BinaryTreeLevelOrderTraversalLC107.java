package trees.learnyard.levelordertraversal;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalLC107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrderBottomList = new ArrayList<>();
        TreeNode current = root;
        if (current == null) {
            return levelOrderBottomList;
        } else {

            Queue<TreeNode> nodeQueue = new LinkedList<>();
            nodeQueue.add(current);
            while (!nodeQueue.isEmpty()) {
                int size = nodeQueue.size();
                List<Integer> innerLevel = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode peekNode = nodeQueue.peek();
                    innerLevel.add(peekNode.data);
                    if (peekNode.left != null) {
                        nodeQueue.add(peekNode.left);
                    }
                    if (peekNode.right != null) {
                        nodeQueue.add(peekNode.right);
                    }
                    nodeQueue.poll();
                }
                levelOrderBottomList.add(0, innerLevel);
            }
        }
        return levelOrderBottomList;

    }
}
