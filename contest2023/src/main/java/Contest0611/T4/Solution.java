package Contest0611.T4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author IronSid
 * @since 2023-06-11 10:29
 */
public class Solution {

    private int[] b;

    public int[] maximumSumQueries(int[] n1, int[] n2, int[][] queries) {
        int n = n1.length;
        // 离散化n2
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(n2[i]);
        Integer[] values = set.toArray(new Integer[0]);
        Arrays.sort(values, (o1, o2) -> o2 - o1);
        HashMap<Integer, Integer> r2 = new HashMap<>();
        // 树状数组维护最大和
        b = new int[values.length + 1];
        Arrays.fill(b, Integer.MIN_VALUE);
        for (int i = 0; i < values.length; i++) r2.put(values[i], i);
        // 记录每个n1的值对应的n2的最大值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(n1[i], n2[i], Integer::max);
        }
        Map.Entry<Integer, Integer>[] list = map.entrySet().toArray(new Map.Entry[0]);
        // 按照n1的逆序排列
        Arrays.sort(list, ((o1, o2) -> o2.getKey() - o1.getKey()));
        // 计算 list 的前缀的k,v之和的最大值
        int[] max = new int[list.length];
        for (int i = 0, t = 0; i < list.length; i++) {
            t = Math.max(t, list[i].getKey() + list[i].getValue());
            max[i] = t;
        }
        int[] ans = new int[queries.length];
        Integer[] idx = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            idx[i] = i;
        }
        // 按照x逆序排列，进行排序离线查询
        Arrays.sort(idx, (o1, o2) -> queries[o2][0] - queries[o1][0]);
        for (int i = 0, p = 0; i < queries.length; i++) {
            int x = queries[idx[i]][0], y = queries[idx[i]][1];
            // 把k大于等于x的k,v对都加入
            for (; p < list.length; p++) {
                if (list[p].getKey() < x) break;
                int k = list[p].getKey(), v = list[p].getValue();
                add(r2.get(v) + 1, k + v);
            }
            // 找values中大于等于y的最后一个元素
            int l = 0, r = values.length - 1;
            while (l <= r) {
                int mid = l + r >>> 1;
                if (values[mid] >= y) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // 查询v大于等于y的k,v对中的最大和
            int res = query(r + 1);
            ans[idx[i]] = res != Integer.MIN_VALUE ? res : -1;
        }
        return ans;
    }

    void add(int x, int v) {
        while (x < b.length) {
            b[x] = Math.max(b[x], v);
            x += x & -x;
        }
    }

    // 返回 arr[0:x) 最大值
    int query(int x) {
        int res = Integer.MIN_VALUE;
        while (x > 0) {
            res = Math.max(res, b[x]);
            x &= x - 1;
        }
        return res;
    }
}
