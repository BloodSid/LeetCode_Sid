package leetcode.editor.cn;

import java.util.*;

/**
 * 跳跃游戏 IV
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-23 15:36:56
 */
public class JumpGameIvSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minJumps(int[] arr) {
        HashMap<Integer, List<Integer>> indexMap = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // 若是连续连续相同数字则跳过
            if (i > 0 && arr[i - 1] == arr[i] && i < arr.length - 1 && arr[i + 1] == arr[i]) {
                continue;
            }
            if (!indexMap.containsKey(arr[i])) {
                indexMap.put(arr[i], new ArrayList<>());
            }
            indexMap.get(arr[i]).add(i);
        }
        int step = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == arr.length - 1) {
                    return step;
                }
                // 相邻的点都入队
                // indexMap 和 visited共同记录是否访问过
                if (curr > 0 && arr[curr] != arr[curr - 1] && indexMap.containsKey(arr[curr - 1])
                        && visited.add(curr - 1)) {
                    queue.offer(curr - 1);
                }
                if (arr[curr] != arr[curr + 1] && indexMap.containsKey(arr[curr + 1])
                        && visited.add(curr + 1)) {
                    queue.offer(curr + 1);
                }
                if (indexMap.containsKey(arr[curr])) {
                    for (Integer integer : indexMap.get(arr[curr])) {
                        if (integer != curr) {
                            queue.offer(integer);
                        }
                    }
                    indexMap.remove(arr[curr]);
                }
            }
            step++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
