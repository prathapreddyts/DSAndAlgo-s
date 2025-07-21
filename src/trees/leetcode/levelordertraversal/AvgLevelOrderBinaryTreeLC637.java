package trees.leetcode.levelordertraversal;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AvgLevelOrderBinaryTreeLC637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelAvg = new ArrayList<>();
        if (root == null) return levelAvg;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                sum += node.data;

                if (node.left != null) nodeQueue.add(node.left);
                if (node.right != null) nodeQueue.add(node.right);
            }

            double avg = sum / size;
            levelAvg.add(avg);
        }

        return levelAvg;
    }

}
