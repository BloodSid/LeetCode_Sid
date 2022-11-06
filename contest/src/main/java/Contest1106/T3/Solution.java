package Contest1106.T3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2022-11-06 10:10
 */
public class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long tot = 0L;
        int n = costs.length;
        // 存储可用的工人，代价升序，下标升序排列
        Comparator<Integer> comparator = (o1, o2) -> costs[o1] == costs[o2] ? o1 - o2 : costs[o1] - costs[o2];
        PriorityQueue<Integer> l = new PriorityQueue<>(comparator);
        PriorityQueue<Integer> r = new PriorityQueue<>(comparator);
        // 初始化
        for (int i = 0; i < candidates; i++) {
            l.offer(i);
        }
        // 只入一个堆，不重复入堆
        for (int i = Math.max(candidates, n - candidates); i < n; i++) {
            r.offer(i);
        }
        int left = candidates;
        int right = n - 1 - candidates;
        for (int i = 0; i < k; i++) {
            // 判断从哪个堆中取
            PriorityQueue<Integer> q;
            if (l.isEmpty()) q = r;
            else if (r.isEmpty()) q = l;
            else q = costs[l.peek()] <= costs[r.peek()] ? l : r;
            int cur = q.poll();
            tot += costs[cur];
            // 还有未入 list 的工人，判断这次选择的工人在哪边，从对应边加入一个工人到 list
            if (left <= right) {
                if (cur < left) {
                    l.offer(left++);
                } else {
                    r.offer(right--);
                }
            }
        }
        return tot;
    }
}
