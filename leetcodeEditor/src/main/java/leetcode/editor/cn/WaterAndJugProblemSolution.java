package leetcode.editor.cn;

import java.util.*;

/**
 * 水壶问题
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-14 16:18:39 
 */
public class WaterAndJugProblemSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static final long N = (int) (1e6) + 1;

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        HashSet<Long> visited = new HashSet<>();
        // 队列中的元素{i,j}, i 表示罐1, j 表示罐2
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited.add(0 * N + 0);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int i = poll[0], j = poll[1];
            if (j == targetCapacity || i == targetCapacity || i + j == targetCapacity) {
                return true;
            }
            // 装满任意一个水壶，清空任意一个水壶，从一个壶向另一个壶倒水
            int[][] next = {{jug1Capacity, j}, {i, jug2Capacity}, {0, j}, {i, 0}, {i + j, 0}, {0, i + j}};
            // 倒水的时候倒满了
            if (next[4][0] > jug1Capacity) {
                next[4][1] = next[5][0] - jug1Capacity;
                next[4][0] = jug1Capacity;
            }
            if (next[5][1] > jug2Capacity) {
                next[5][0] = next[5][1] - jug2Capacity;
                next[5][1] = jug2Capacity;
            }
            for (int[] ints : next) {
                int ni = ints[0], nj = ints[1];
                long v = ni * N + nj;
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.offer(ints);
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
