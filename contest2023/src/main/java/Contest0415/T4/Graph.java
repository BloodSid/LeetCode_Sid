package Contest0415.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-04-15 22:59
 */
public class Graph {

    public static final int INF = (int) (1e9 + 7);
    private final int[][] g;
    private final int n;
    private boolean needUpdate;

    public Graph(int n, int[][] edges) {
        g = new int[n][n];
        this.n = n;
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], INF);
            g[i][i] = 0;
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], w = edge[2];
            g[from][to] = w;
        }
        needUpdate = true;
    }

    public void addEdge(int[] edge) {
        int from = edge[0], to = edge[1], w = edge[2];
        if (w >= g[from][to]) return;
        g[from][to] = w;
        needUpdate = true;
    }

    public int shortestPath(int node1, int node2) {
        if (needUpdate) update();
        needUpdate = false;
        return g[node1][node2] != INF ? g[node1][node2] : -1;
    }

    void update() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
    }
}
