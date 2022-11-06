package Contest1106.T3;

import java.util.TreeSet;

/**
 * @author IronSid
 * @since 2022-11-06 10:10
 */
public class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long tot = 0L;
        int n = costs.length;
        // 存储可用的工人，代价升序，下标升序排列
        TreeSet<Integer> list = new TreeSet<>((o1, o2) -> costs[o1] == costs[o2] ? o1 - o2 : costs[o1] - costs[o2]);
        // 初始化
        for (int i = 0; i < candidates; i++) {
            list.add(i);
        }
        for (int i = n - candidates; i < n; i++) {
            list.add(i);
        }
        int left = candidates;
        int right = n - 1 - candidates;
        for (int i = 0; i < k; i++) {
            int cur = list.first();
            list.remove(cur);
            tot += costs[cur];
            // 还有未入 list 的工人，判断这次选择的工人在哪边，从对应边加入一个工人到 list
            if (left <= right) {
                if (cur < left) {
                    list.add(left++);
                } else {
                    list.add(right--);
                }
            }
        }
        return tot;
    }
}
