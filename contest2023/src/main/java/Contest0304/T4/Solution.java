package Contest0304.T4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    private int ans;
    private HashMap<Integer, HashSet<Integer>> map;
    private int n;
    private int k;
    private Set<Integer>[] child;
    private HashSet<String> g;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        g = new HashSet<>();
        // 缓存所有 guess 的方向
        for (int[] guess : guesses) {
            g.add(guess[0] + "," + guess[1]);
        }
        this.n = edges.length + 1;
        this.k = k;
        map = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0],  y = edge[1];
            addEdge(x, y);
            addEdge(y, x);
        }
        // 以 0 为根，记录每个边的方向
        child = new Set[n];
        boolean[] vis = new boolean[n];
        // 计算 0 的score
        int score = dfs0(0, -1, vis);
        dfs1(0, -1, score);
        return ans;
    }

    void addEdge(int a, int b) {
        if (!map.containsKey(a)) {
            map.put(a, new HashSet<>());
        }
        map.get(a).add(b);
    }

    int dfs0(int cur, int parent, boolean[] vis) {
        vis[cur] = true;
        int sum = 0;
        if (g.contains(parent + "," + cur)) sum++;
        if (map.containsKey(cur)) {
            for (Integer next : map.get(cur)) {
                if (vis[next]) continue;
                // 记录以0为起点的树中的父子关系
                if (child[cur] == null) child[cur] = new HashSet<>();
                child[cur].add(next);
                sum += dfs0(next, cur, vis);
            }
        }
        return sum;
    }

    void dfs1(int cur, int parent, int score) {
        // 每进入一个节点，它和父节点的边的方向进行反转，如果是顺向变逆向，score--, 逆向变顺向，score++,不在集合中，不变
        String old = parent + "," + cur;
        String now = cur + "," + parent;
        if (g.contains(old) && g.contains(now)) {
            // g中含有双向的边，score不变
        } else if (g.contains(old)) {
            // 顺向变逆向
            score--;
        } else if (g.contains(now)) {
            // 逆向变顺向
            score++;
        }
        // 判断当前节点是不是可行根
        if (score >= k) {
            ans++;
        }
        // 递归计算子结点的 score
        if (child[cur] != null) {
            for (Integer next : child[cur]) {
                dfs1(next, cur, score);
            }
        }
    }
}
