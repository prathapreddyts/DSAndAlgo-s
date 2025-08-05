package graphs.tuf.traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindPaths {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adjList = buildAdjList(n, edges);
        return dfsIterative(adjList, source, destination);
    }

    private List<List<Integer>> buildAdjList(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }

    private boolean dfsIterative(List<List<Integer>> adjList, int source, int destination) {
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (node == destination){
                return true;
            }
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }

}
