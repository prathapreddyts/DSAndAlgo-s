package graphs.tuf.cycles;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUnDirectedGraph {
    public boolean isCycle(int V, List<Integer>[] adj) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                queue.add(new int[]{i, -1});
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    int node = current[0];
                    int parent = current[1];
                    for (int neighbor : adj[node]) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(new int[]{neighbor, node}); // Pass current node as parent
                        } else if (neighbor != parent) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
