package graphs.tuf.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Provinces {
    public int numProvinces(int[][] adj) {
        int len = adj.length;
        List<List<Integer>> adjacentLists = adjacentList(adj);
        boolean[] visited = new boolean[len];
        int count = 0;
        for (int node = 0; node < len; node++) {
            if (visited[node] == false) {
                dfsIterative(adjacentLists, visited, node);
                count++;
            }
        }
        return count;
    }

    private void dfsIterative(List<List<Integer>> adjacentLists, boolean[] visited, int node) {
        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.push(node);
        visited[node] = true;
        while (!nodeStack.isEmpty()) {
            int popNode = nodeStack.pop();
            for (int adjNode : adjacentLists.get(popNode)) {
                if (!visited[adjNode]) {
                    nodeStack.push(adjNode);
                    visited[adjNode] = true;
                }
            }
        }
    }


    public List<List<Integer>> adjacentList(int[][] adjMatrix) {
        int length = adjMatrix.length;
        List<List<Integer>> adjacentList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            adjacentList.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && adjMatrix[i][j] == 1) {
                    adjacentList.get(i).add(j);
                }
            }
        }
        return adjacentList;
    }

}
