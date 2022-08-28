package Contest0828.T4;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-08-28 0:33
 */
public class Solution {

    public static final int[][] EMPTY = new int[][]{};

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // 拓扑排序
        int[] rowSorted = sort(k, rowConditions);
        int[] colSorted = sort(k, colConditions);
        if (rowSorted == null || colSorted == null) return EMPTY;
        // 根据拓扑排序建立　
        int[] rowPos = new int[k + 1];
        for (int i = 0; i < rowSorted.length; i++) {
            rowPos[rowSorted[i]] = i;
        }
        int[][] ans = new int[k][k];
        for (int i = 0; i < colSorted.length; i++) {
            ans[rowPos[colSorted[i]]][i] = colSorted[i];
        }
        return ans;
    }

    int[] sort(int k, int[][] edges) {
        int[] res = new int[k];
        int p = 0;
        int[] inCnt = new int[k + 1];
        List<Integer>[] map = new List[k + 1];
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            inCnt[to]++;
            if (map[from] == null) map[from] = new ArrayList<>();
            map[from].add(to);
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inCnt[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int poll = q.poll();
            res[p++] = poll;
            if (map[poll] == null) continue;
            for (int to : map[poll]) {
                inCnt[to]--;
                if (inCnt[to] == 0) q.offer(to);
            }
        }
        // 存在环，无法拓扑排序
        if (p != k) return null;
        return res;
    }
}
