package leetcode.editor.cn;
//你现在手里有一份大小为 N x N 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，请你找出一个海洋单
//元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的。 
//
// 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - 
//x1| + |y0 - y1| 。 
//
// 如果网格上只有陆地或者海洋，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[[1,0,1],[0,0,0],[1,0,1]]
//输出：2
//解释： 
//海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
// 
//
// 示例 2： 
//
// 
//
// 输入：[[1,0,0],[0,0,0],[0,0,0]]
//输出：4
//解释： 
//海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 100 
// grid[i][j] 不是 0 就是 1 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 
// 👍 215 👎 0


import java.util.*;

/**
 * 地图分析
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-09-04 23:50:17
 */
public class AsFarFromLandAsPossibleSolution {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistance(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new ArrayDeque<>();
            int land = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        land++;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            if (land == 0 || land == m * n) {
                return -1;
            }
            int dist = -1;
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    int[] head = queue.poll();
                    List<int[]> nexts = getNext(head, m, n);
                    for (int[] next : nexts) {
                        if (grid[next[0]][next[1]] == 0) {
                            queue.offer(next);
                            grid[next[0]][next[1]] = 1;
                        }
                    }
                }
                dist++;
            }

            return dist;
        }

        int[][] offsets = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        List<int[]> getNext(int[] pos, int m, int n) {
            List<int[]> res = new ArrayList<>(4);
            for (int[] offset : offsets) {
                int[] next = new int[2];
                for (int i = 0; i < 2; i++) {
                    next[i] = pos[i] + offset[i];
                }
                if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n) {
                    res.add(next);
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
