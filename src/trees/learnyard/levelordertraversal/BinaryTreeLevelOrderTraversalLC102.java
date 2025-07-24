package trees.learnyard.levelordertraversal;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalLC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<>();
        TreeNode current = root;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
       if(current!=null){
           nodeQueue.add(current);
       }
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            List<Integer> innerLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode peekNode = nodeQueue.poll();
                innerLevel.add(peekNode.data);

                if (peekNode.left != null) {
                    nodeQueue.add(peekNode.left);
                }
                if (peekNode.right != null) {
                    nodeQueue.add(peekNode.right);
                }
            }
            levelOrderList.add(innerLevel);
        }
        return levelOrderList;
    }
}
