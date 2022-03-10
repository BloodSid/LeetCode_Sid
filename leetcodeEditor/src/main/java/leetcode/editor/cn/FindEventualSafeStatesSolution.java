package leetcode.editor.cn;

import java.util.*;

/**
 * 找到最终的安全状态
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-09 17:06:43
 */
public class FindEventualSafeStatesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 一个点出发的边的链表的头节点 he，边指向的点 e，边在链表中的下一个边ne
    int[] he, e, ne;
    int idx = 0;
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 边的数量
        int m = n * 4;
        // 初始化
        he = new int[n];
        e = new int[m];
        ne = new int[m];
        idx = 0;
        Arrays.fill(he, -1);
        // 反向存图，并统计入度
        int[] inCnt = new int[n];
        for (int i = 0; i < graph.length; i++) {
            for (int j : graph[i]) {
                add(j, i);
                inCnt[i]++;
            }
        }
        // 使用队列进行拓扑排序
        Deque<Integer> queue = new ArrayDeque<>();
        // 把入度为零的节点（对应原图中出度为零的节点即安全节点）入队
        for (int i = 0; i < n; i++) {
            if (inCnt[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            // 遍历当前点的出边，把这些边所进入的点的入度减一
            for (int edge = he[cur]; edge != -1; edge = ne[edge]) {
                int to = e[edge];
                inCnt[to]--;
                if (inCnt[to] == 0) queue.offer(to);
            }
        }
        // 拓扑排序之后入度为零的就是安全节点
        List<Integer> safe = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inCnt[i] == 0) safe.add(i);
        }
        return safe;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
