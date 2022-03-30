package leetcode.editor.cn;

import java.util.*;

/**
 * 找到处理最多请求的服务器
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-30 20:30:45 
 */
public class FindServersThatHandledMostNumberOfRequestsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // 结束处理前一个任务的时间
        int[] cnt = new int[k];
        int[] end = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> end[o1] - end[o2]);
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            set.add(i);
        }
        for (int i = 0; i < arrival.length; i++) {
            while (!pq.isEmpty() && end[pq.peek()] <= arrival[i]) {
                set.add(pq.poll());
            }
            Integer idx = set.ceiling(i % k);
            if (idx == null) idx = set.ceiling(0);
            if (idx == null) continue;
            end[idx] = arrival[i] + load[i];
            cnt[idx]++;
            pq.offer(idx);
            set.remove(idx);
        }
        List<Integer> list = new ArrayList<>();
        int maxCnt = 0;
        for (int i = 0; i < k; i++) {
            if (cnt[i] == maxCnt) {
                list.add(i);
            } else if (cnt[i] > maxCnt) {
                maxCnt = cnt[i];
                list.clear();
                list.add(i);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
