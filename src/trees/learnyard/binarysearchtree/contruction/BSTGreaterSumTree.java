package trees.learnyard.binarysearchtree.contruction;

import trees.TreeNode;


import java.util.*;

public class BSTGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        bstToGstHelper(root, inOrderList);
        return root;

    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }

    private void bstToGstHelper(TreeNode root, List<Integer> inOrderList) {
        inorderTraversal(root, inOrderList);
        Map<Integer, Integer> indexMap = new HashMap<>();
        int sum = 0;
        for (int i = inOrderList.size() - 1; i >= 0; i--) {
            sum += inOrderList.get(i);
            indexMap.put(inOrderList.get(i), sum);
        }
        updateTreeWithGreaterSum(root, indexMap);
    }
    private void updateTreeWithGreaterSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;
        updateTreeWithGreaterSum(root.left, map);
        root.data = map.get(root.data);
        updateTreeWithGreaterSum(root.right, map);
    }


}
