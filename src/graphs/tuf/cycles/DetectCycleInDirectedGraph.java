package graphs.tuf.cycles;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DetectCycleInDirectedGraph {
    public boolean hasCycle(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];

        for (int start = 0; start < n; start++) {
            if (!visited[start]) {
                if (dfsIterative(start, adj, visited, inStack)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfsIterative(int start, List<List<Integer>> adj, boolean[] visited, boolean[] inStack) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> path = new Stack<>();

        stack.push(start);
        path.push(start);
        visited[start] = true;
        inStack[start] = true;

        while (!stack.isEmpty()) {
            int node = stack.peek();

            boolean hasUnvisitedNeighbor = false;
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    inStack[nei] = true;
                    stack.push(nei);
                    path.push(nei);
                    hasUnvisitedNeighbor = true;
                    break;
                } else if (inStack[nei]) {
                    return true;
                }
            }
            if (!hasUnvisitedNeighbor) {
                stack.pop();
                inStack[node] = false;
                path.pop();
            }
        }
        return false;
    }

    public List<List<Integer>> adjList(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && edges[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;
    }
}
