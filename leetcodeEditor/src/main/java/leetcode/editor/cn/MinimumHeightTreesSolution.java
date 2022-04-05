package leetcode.editor.cn;

import java.util.*;

/**
 * 最小高度树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-06 00:04:43 
 */
public class MinimumHeightTreesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<Integer>[] map;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Arrays.asList(0);
        int[] cnt = new int[n];
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new LinkedList<>();
        }
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
            cnt[edge[0]]++;
            cnt[edge[1]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 1) {
                queue.offer(i);
            }
        }
        int remain = n;
        while (remain > 2) {
            int size = queue.size();
            remain -= size;
            for (int i = 0; i < size; i++) {
                int vertex = queue.poll();
                for (Integer next : map[vertex]) {
                        if (--cnt[next] == 1) {
                            queue.offer(next);
                    }
                }
            }
        }
        return (List<Integer>) queue;
    }

    private void add(int from, int to) {
        map[from].add(to);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
