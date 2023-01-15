package Contest0115.T4;

import java.util.*;

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
        dfs(0, vis);
        // 计算每个节点到根节点的权重
        return max;
    }

    void add(int from, int to) {
        map[from].add(to);
    }


    // 返回此节点往下的最长路径, 和不含叶子节点的最长路径
    void dfs(int cur, boolean[] vis) {
        vis[cur] = true;
        // 小顶堆记录两种情况下的最大值
        PriorityQueue<Integer> hasLeaf = new PriorityQueue<>(Comparator.comparingLong(o -> maxHas[o]));
        PriorityQueue<Integer> noLeaf = new PriorityQueue<>(Comparator.comparingLong(o -> maxNo[o]));
        int cnt = 0;
        for (Integer next : map[cur]) {
            if (!vis[next]) {
                cnt++;
                dfs(next, vis);
                hasLeaf.offer(next);
                if (hasLeaf.size() > 2) hasLeaf.poll();
                noLeaf.offer(next);
                if (noLeaf.size() > 2) noLeaf.poll();
            }
        }
        // 判断有端点的最大和无端点的最大是否重复
        List<Integer> hList = new ArrayList<>(), nList = new ArrayList<>();
        while (!hasLeaf.isEmpty()) {
            hList.add(0, hasLeaf.poll());
        }
        while (!noLeaf.isEmpty()) {
            nList.add(0, noLeaf.poll());
        }
        boolean same = Objects.equals(hList.isEmpty() ? null : hList.get(0), nList.isEmpty() ? null :nList.get(0));
        long h1 = hList.size() <= 0 ? 0 : maxHas[hList.get(0)];
        long h2 = hList.size() <= 1 ? 0 : maxHas[hList.get(1)];
        long n1 = nList.size() <= 0 ? 0 : maxNo[nList.get(0)];
        long n2 = nList.size() <= 1 ? 0 : maxNo[nList.get(1)];
        // 子树内经过 cur 节点的最大开销
        long subMax = 0;
        if (cnt == 0) {
            // 叶子节点
            maxHas[cur] = price[cur];
            maxNo[cur] = 0;
        } else {
            maxHas[cur] = h1 + price[cur];
            maxNo[cur] = n1 + price[cur];
            if (same) {
                // 特判，只有一棵子树，这时不能选当前节点
                if (h2 == 0) subMax = Math.max(subMax, h1);
                else subMax = Math.max(subMax, h1 + n2 + price[cur]);
                subMax = Math.max(subMax, h2 + n1 + price[cur]);
            } else {
                subMax = Math.max(subMax, h1 + n1 + price[cur]);
            }
        }

        max = Math.max(max, subMax);
    }
}
