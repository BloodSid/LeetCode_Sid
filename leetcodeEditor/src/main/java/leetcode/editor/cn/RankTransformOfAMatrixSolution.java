package leetcode.editor.cn;
//给你一个 m x n 的矩阵 matrix ，请你返回一个新的矩阵 answer ，其中 answer[row][col] 是 matrix[row][
//col] 的秩。 
//
// 每个元素的 秩 是一个整数，表示这个元素相对于其他元素的大小关系，它按照如下规则计算： 
//
// 
// 秩是从 1 开始的一个整数。 
// 如果两个元素 p 和 q 在 同一行 或者 同一列 ，那么： 
// 
// 如果 p < q ，那么 rank(p) < rank(q) 
// 如果 p == q ，那么 rank(p) == rank(q) 
// 如果 p > q ，那么 rank(p) > rank(q) 
// 
// 秩 需要越 小 越好。 
// 
//
// 题目保证按照上面规则 answer 数组是唯一的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[1,2],[2,3]]
//解释：
//matrix[0][0] 的秩为 1 ，因为它是所在行和列的最小整数。
//matrix[0][1] 的秩为 2 ，因为 matrix[0][1] > matrix[0][0] 且 matrix[0][0] 的秩为 1 。
//matrix[1][0] 的秩为 2 ，因为 matrix[1][0] > matrix[0][0] 且 matrix[0][0] 的秩为 1 。
//matrix[1][1] 的秩为 3 ，因为 matrix[1][1] > matrix[0][1]， matrix[1][1] > matrix[1][0
//] 且 matrix[0][1] 和 matrix[1][0] 的秩都为 2 。
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[7,7],[7,7]]
//输出：[[1,1],[1,1]]
// 
//
// 示例 3： 
// 
// 
//输入：matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
//输出：[[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
// 
//
// 示例 4： 
// 
// 
//输入：matrix = [[7,3,6],[1,4,5],[9,8,2]]
//输出：[[5,1,4],[1,2,3],[6,3,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 500 
// -10⁹ <= matrix[row][col] <= 10⁹ 
// 
//
// 👍 116 👎 0


import java.util.*;
import java.util.stream.IntStream;

/**
 * 矩阵转换后的秩
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-01-25 18:43:06 
 */
public class RankTransformOfAMatrixSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int m;
    private int n;
    private int[] p;
    private int[] inCnt;
    private HashMap<Integer, List<Integer>> map;

    public int[][] matrixRankTransform(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        p = IntStream.range(0, m * n).toArray();
        int[][] rank = new int[m][n];
        // 同行同列按元素值分组
        HashMap<Integer, List<int[]>>[] lineMaps = new HashMap[m];
        HashMap<Integer, List<int[]>>[] rowMaps = new HashMap[n];
        for (int i = 0; i < m; i++) lineMaps[i] = new HashMap<>();
        for (int j = 0; j < n; j++) rowMaps[j] = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (!lineMaps[i].containsKey(val)) {
                    lineMaps[i].put(val, new ArrayList<>());
                }
                lineMaps[i].get(val).add(new int[]{i, j});
                if (!rowMaps[j].containsKey(val)) {
                    rowMaps[j].put(val, new ArrayList<>());
                }
                rowMaps[j].get(val).add(new int[]{i, j});
            }
        }
        // 把 rank 一定相等的元素通过并查集连起来
        unionMaps(lineMaps);
        unionMaps(rowMaps);
        // 把同行同列排序后的相邻不相等元素之间建边
        map = new HashMap<>();
        inCnt = new int[m * n];
        buildMap(lineMaps);
        buildMap(rowMaps);
        // 拓扑排序
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                // 根节点且入度为一入队
                if (p[idx] == idx && inCnt[idx] == 0) {
                    q.offer(idx);
                }
            }
        }
        int curRank = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                if (map.containsKey(poll)) {
                    // 图中只有根节点，所以可以直接操作 to
                    for (Integer to : map.get(poll)) {
                        inCnt[to]--;
                        if (inCnt[to] == 0) q.offer(to);
                    }
                }
                int[] p = pos(poll);
                rank[p[0]][p[1]] = curRank;
            }
            curRank++;
        }
        // 填数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                // 非根节点
                if (p[idx] != idx) {
                    int[] r = pos(find(idx));
                    rank[i][j] = rank[r[0]][r[1]];
                }
            }
        }
        return rank;
    }

    void addEdge(int from, int to) {
        inCnt[to]++;
        if (!map.containsKey(from)) map.put(from, new ArrayList<>());
        map.get(from).add(to);
    }

    void buildMap(HashMap<Integer, List<int[]>>[] maps) {
        for (HashMap<Integer, List<int[]>> map : maps) {
            Integer[] vals = map.keySet().stream().sorted().toArray(Integer[]::new);
            int[] pre = map.get(vals[0]).get(0);
            for (int i = 1; i < vals.length; i++) {
                int[] cur = map.get(vals[i]).get(0);
                // 建边时用根节点
                addEdge(find(idx(pre)), find(idx(cur)));
                pre = cur;
            }
        }
    }


    void unionMaps(HashMap<Integer, List<int[]>>[] maps) {
        for (HashMap<Integer, List<int[]>> map : maps) {
            for (List<int[]> pos : map.values()) {
                int[] first = null;
                for (int[] po : pos) {
                    if (first == null) first = po;
                    else union(idx(po), idx(first));
                }
            }
        }
    }

    int idx(int[] pos) {
        return pos[0] * n + pos[1];
    }

    int[] pos(int idx) {
        return new int[]{idx / n, idx % n};
    }

    void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        if (rx != ry) {
            p[rx] = ry;
        }
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
