package Contest0121.T4;

/**
 * @author IronSid
 * @since 2024-01-21 10:27
 */
public class Solution {

    private long[] pre;

    public long[] countOfPairs(int n, int x, int y) {
        long[] res = new long[n];
        if (x == y) {
            // 特例
            for (int i = 0; i < n; i++) {
                res[i] = 2L * (n - i - 1);
            }
            return res;
        }
        // 前缀和
        pre = new long[n + 1];
        // 不妨x<y
        if (x > y) {
            int t = x;
            x = y;
            y = t;
        }
        // 环上的点数，分支1和2的点数
        int r = y - x + 1, a1 = x - 1, a2 = n - y;
        // 增加只在环上的
        add(1, (r - 1) / 2, r);
        // 增加两端在同一个分支上的
        countArm(a1);
        countArm(a2);
        if (r % 2 == 0) add(r / 2, r / 2, r / 2);
        // 统计两端各在分支和环上的
        countRingAndArm(r, a1);
        countRingAndArm(r, a2);
        // 统计两端在两个不同分支上的
        for(int i = 1; i <= a1; i++) {
            // a1 -> x -> y -> a2
            add(i + 1 + 1, i + 1 + a2, 1);
        }
        long t = pre[0];
        for (int i = 1; i <= n; i++) {
            t += pre[i];
            res[i - 1] = t;
            // 只统计了一个方向的，故*2
            res[i - 1] *= 2;
        }
        return res;
    }

    private void countArm(int a) {
        for (int i = 1; i < a; i++) {
            add(i, i, a - i);
        }
    }

    private void countRingAndArm(int r, int a) {
        // 枚举分支上的点数
        for(int i = 1; i <= a; i++) {
            // 交点
            add(i, i, 1);
            // 其他点
            add(i + 1 , i + (r - 1) / 2, 2);
            // 交点的对角
            if (r % 2 == 0) {
                add(i + r / 2, i + r / 2, 1);
            }
        }

    }

    // [l,r] 上增加 val
    void add(int l, int r, long val) {
        pre[l] += val;
        pre[r + 1] -= val;
    }
}
