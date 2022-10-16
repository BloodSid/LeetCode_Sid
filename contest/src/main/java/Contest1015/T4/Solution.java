package Contest1015.T4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-10-15 22:31
 */
public class Solution {
    private int[] nums;
    private List<Integer>[] map;

    public int componentValue(int[] nums, int[][] edges) {
        this.nums = nums;
        int n = nums.length;
        // 建立无向图
        map = new List[n];
        for (int[] edge : edges) {
            add(edge[0], edge[1], map);
            add(edge[1], edge[0], map);
        }
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        boolean[] vis = new boolean[n];
        // 枚举联通块的数量 i
        for (int i = Math.min(n, sum / max); i > 1; i--) {
            Arrays.fill(vis, false);
            // 检查每个连通块的价值是否恰为为 sum / i
            if (sum % i == 0 && dfs(0, sum / i, vis) == 0) return i - 1;
        }
        return 0;
    }

    // 如果子树和小于 k 返回 k; 如果子树和等于 k 返回 0, 表示该子树和父节点被分开, 并得到一个价值恰为 k 的连通块; 如果子树和大于 k 返回 -1, 表示该子树无法被成功分割
    int dfs(int node, int k, boolean[] vis) {
        vis[node] = true;
        int res = nums[node];
        List<Integer> ns = map[node];
        if (ns != null) {
            for (Integer next : ns) {
                if (!vis[next]) {
                    int dfs = dfs(next, k, vis);
                    if (dfs == -1) return -1;
                    res += dfs;
                }
            }
        }
        if (res > k) return -1;
        else if (res == k) return 0;
        return res;
    }

    void add(int x, int y, List<Integer>[] map) {
        if (map[x] == null) map[x] = new ArrayList<>();
        map[x].add(y);
    }
}
