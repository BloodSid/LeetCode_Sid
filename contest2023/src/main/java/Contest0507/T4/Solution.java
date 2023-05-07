package Contest0507.T4;

/**
 * @author IronSid
 * @since 2023-05-07 10:38
 */
public class Solution {
    private int[] cost;
    private int res;

    public int minIncrements(int n, int[] cost) {
        this.cost = cost;
        res = 0;
        dfs(0);
        return res;
    }

    long dfs(int i) {
        // 叶子节点
        if (i > cost.length / 2 - 1) {
            return cost[i];
        }
        long l = dfs(2 * i + 1);
        long r = dfs(2 * i + 2);
        long d = Math.abs(l - r);
        res += d;
        if (l > r) {
            cost[2 * i + 2] += d;
        } else {
            cost[2 * i + 1] += d;
        }
        return Math.max(l, r) + cost[i];
    }
}
