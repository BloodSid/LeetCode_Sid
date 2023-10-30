package Contest1028.T4;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2023-10-28 22:38
 */
public class Solution {

    public static final int M = (int) (1e9 + 7);
    private long[] sum;
    private long[] tag;

    public int sumCounts(int[] nums) {
        long res = 0;
        int n = nums.length;
        sum = new long[4 * n];
        tag = new long[4 * n];
        HashMap<Integer, Integer> last = new HashMap<>();
        // 以当前位置结尾的子数组不同元素数目的平方和
        long dp = 0;
        for (int i = 0; i < n; i++) {
            int l = last.getOrDefault(nums[i], -1);
            // 增量法更新子数组不同元素数目：[0...l, i] 不变，[l+1...i, i] 加一
            // 更新区间 [l+1,i] 并且使用区间和计算增量
            dp += queryAndAdd1(1, 1, n, l + 2, i + 1) * 2 + i - l;
            res = (res + dp) % M;
            last.put(nums[i], i);
        }
        return (int) (res % M);
    }

    // 更新标记
    void updateTag(int cur, int l, int r, long add) {
        sum[cur] += add * (r - l + 1);
        tag[cur] += add;
    }

    // 把[l,r]加一，同时返回加一之前的区间和
    long queryAndAdd1(int cur, int l, int r, int L, int R) {
        // 目标区间包含当前区间，直接返回
        if (L <= l && r <= R) {
            long res = sum[cur];
            // 更新当前区间的标记以进行加一的操作
            updateTag(cur, l, r, 1);
            return res;
        }

        int mid = l + r >> 1;
        long add = tag[cur];
        // 如果当前节点的标记非空，说明当前节点有以前未处理的tag，则更新当前节点两个子节点的值和懒标记值（区间修改和区间查询共用）
        if (add != 0) {
            updateTag(cur * 2, l, mid, add);
            updateTag(cur * 2 + 1, mid + 1, r, add);
            // 清空当前节点的标记
            tag[cur] = 0;
        }

        // 迭代处理两个子节点（区间修改和区间查询共用）
        long res = 0;
        if (L <= mid) res += queryAndAdd1(2 * cur, l, mid, L, R);
        if (R > mid) res += queryAndAdd1(2 * cur + 1, mid + 1, r, L, R);
        // 更新当前节点区间和（区间修改专用）
        sum[cur] = sum[cur * 2] + sum[cur * 2 + 1];
        return res;
    }
}
