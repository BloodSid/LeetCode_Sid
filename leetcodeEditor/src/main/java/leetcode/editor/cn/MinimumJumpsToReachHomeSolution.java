package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * 到家的最少跳跃次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-14 00:05:44
 */
public class MinimumJumpsToReachHomeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashSet<Integer> visited;
    public static final int L = 0;
    public static final int R = 1;
    public static final int N = (int) 1e5;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        visited = new HashSet<>();
        for (int i : forbidden) {
            visited.add(i);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, R});
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                // 可以 +a (以R表示)或者 -b (以L表示)，但是不能连续 -b
                int[] p = queue.poll();
                int i = p[0], direction = p[1];
                if (i == x) return step;
                if (i <= 6000 && !visited.contains(i + a)) {
                    queue.offer(new int[]{i + a, R});
                    // 不能通过前进重复进入同一个点
                    visited.add(i + a);
                }
                if (direction == R && i - b >= 0 && !visited.contains(i - b)) {
                    queue.offer(new int[]{i - b, L});
                    // 左跳不需要记录
                }
            }
            step++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
