package graphs.tuf.traversals;

import java.util.*;

public class ReOrderRoutes {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        Map<String, Boolean> directionMap = new HashMap<>();

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            // Add from -> to in undirected graph
            if (!adjMap.containsKey(from)) {
                adjMap.put(from, new ArrayList<>());
            }
            adjMap.get(from).add(to);
            // Add to -> from in undirected graph
            if (!adjMap.containsKey(to)) {
                adjMap.put(to, new ArrayList<>());
            }
            adjMap.get(to).add(from);
            String direction = from + "_" + to;
            directionMap.put(direction, true);
        }

        boolean[] visited = new boolean[n];
        // Initialize BFS queue with node 0
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        int changes = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            List<Integer> neighbors = adjMap.get(node);
            if (neighbors != null) {
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        String key = node + "_" + neighbor;
                        // If original edge goes away from current node, we need to reverse it
                        if (directionMap.containsKey(key)) {
                            changes++;
                        }

                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return changes;
    }
}

