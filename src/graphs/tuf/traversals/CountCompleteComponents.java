package graphs.tuf.traversals;

import java.util.*;

public class CountCompleteComponents {


    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> cmp = new ArrayList<>();
                bfs(i, adj, vis, cmp);

                boolean isComplete = true;
                for (int node : cmp) {
                    if (adj.get(node).size() != cmp.size() - 1) {
                        isComplete = false;
                        break;
                    }
                }

                if (isComplete) cnt++;
            }
        }

        return cnt;
    }

    public void bfs(int node, List<List<Integer>> adj, boolean[] vis, List<Integer> cmp) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int n = q.poll();
            cmp.add(n);

            for (int nbr : adj.get(n)) {
                if (!vis[nbr]) {
                    q.add(nbr);
                    vis[nbr] = true;
                }
            }
        }
    }

}
