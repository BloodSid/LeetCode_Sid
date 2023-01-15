package Contest0115.T4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2023-01-15 10:20
 */
public class Solution {

    private long max;
    int n;
    private List<Integer>[] map;
    private int[] price;
    private long[] maxHas;
    private long[] maxNo;


    public long maxOutput(int n, int[][] edges, int[] price) {
        this.n = n;
        map = new List[n];
        this.price = price;
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            add(edge[1], edge[0]);
            add(edge[0], edge[1]);
        }
        boolean[] vis = new boolean[n];
        maxHas = new long[n];
        maxNo = new long[n];
        dfs3(0, vis);
        // 计算每个节点到根节点的权重
        return max;
    }

    void add(int from, int to) {
        map[from].add(to);
    }


    // 返回此节点往下的最长路径, 和不含叶子节点的最长路径
    void dfs3(int cur, boolean[] vis) {
        vis[cur] = true;
        // 记录两种情况下的最大值
        PriorityQueue<Integer> hasLeaf = new PriorityQueue<>(Comparator.comparingLong(o -> maxHas[(int) o]).reversed());
        PriorityQueue<Integer> noLeaf = new PriorityQueue<>(Comparator.comparingLong(o -> maxNo[(int) o]).reversed());
        int cnt = 0;
        for (Integer next : map[cur]) {
            if (!vis[next]) {
                cnt++;
                dfs3(next, vis);
                hasLeaf.offer(next);
                if (hasLeaf.size() > 2) hasLeaf.poll();
                noLeaf.offer(next);
                if (noLeaf.size() > 2) noLeaf.poll();
            }
        }
        // 子树内经过 cur 节点的最大开销
        long subMax = 0;
        int firstHas = hasLeaf.isEmpty() ? -1 : hasLeaf.poll();
        int secondHas = hasLeaf.isEmpty() ? -1 : hasLeaf.poll();
        maxHas[cur] = firstHas + price[cur];
        int firstNo = noLeaf.isEmpty() ? -1 : noLeaf.poll();
        int secondNo = noLeaf.isEmpty() ? -1 : noLeaf.poll();
        maxNo[cur] = firstNo + price[cur];
        // 叶子节点
        if (cnt == 0) {
            maxHas[cur] = price[cur];
            maxNo[cur] = price[cur];
        } else if (cnt == 1) {
            maxHas[cur] = firstHas + price[cur];
            maxNo[cur] = firstNo + price[cur];
        } else {
            maxHas[cur] = firstHas + price[cur];
            maxNo[cur] = firstNo + price[cur];
            if (firstHas == firstNo) {
                subMax = Math.max(subMax, maxHas[firstHas] + maxNo[secondNo] - price[cur]);
                subMax = Math.max(subMax, maxHas[secondHas] + maxNo[firstNo] - price[cur]);
            } else {
                subMax = Math.max(subMax, maxHas[firstHas] + maxNo[firstNo] - price[cur]);
            }
        }
        max = Math.max(max, subMax);
    }
}
