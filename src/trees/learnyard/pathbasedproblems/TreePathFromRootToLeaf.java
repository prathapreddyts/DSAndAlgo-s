package trees.learnyard.pathbasedproblems;

import trees.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class TreePathFromRootToLeaf {


    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<TreeNode> leafNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        parentMap.put(root, null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left == null && node.right == null) {
                leafNodes.add(node);
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }

            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }

        for (TreeNode leaf : leafNodes) {
            List<String> path = new ArrayList<>();
            TreeNode current = leaf;
            while (current != null) {
                path.add(String.valueOf(current.data));
                current = parentMap.get(current);
            }
            Collections.reverse(path);
            result.add(String.join("->", path));
        }

        return result;
    }
}




