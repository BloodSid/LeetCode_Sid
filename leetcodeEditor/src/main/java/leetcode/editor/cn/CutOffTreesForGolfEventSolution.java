package leetcode.editor.cn;
//你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个 m x n 的矩阵表示， 在这个矩阵中： 
//
// 
// 0 表示障碍，无法触碰 
// 1 表示地面，可以行走 
// 比 1 大的数 表示有树的单元格，可以行走，数值表示树的高度 
// 
//
// 每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。 
//
// 你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。 
//
// 你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。 
//
// 可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。 
//
// 
//
// 示例 1： 
//
// 
//输入：forest = [[1,2,3],[0,0,4],[7,6,5]]
//输出：6
//解释：沿着上面的路径，你可以用 6 步，按从最矮到最高的顺序砍掉这些树。 
//
// 示例 2： 
//
// 
//输入：forest = [[1,2,3],[0,0,0],[7,6,5]]
//输出：-1
//解释：由于中间一行被障碍阻塞，无法访问最下面一行中的树。
// 
//
// 示例 3： 
//
// 
//输入：forest = [[2,3,4],[0,0,5],[8,7,6]]
//输出：6
//解释：可以按与示例 1 相同的路径来砍掉所有的树。
//(0,0) 位置的树，可以直接砍去，不用算步数。
// 
//
// 
//
// 提示： 
//
// 
// m == forest.length 
// n == forest[i].length 
// 1 <= m, n <= 50 
// 0 <= forest[i][j] <= 10⁹ 
// 
// 👍 197 👎 0


import java.util.*;

/**
 * 为高尔夫比赛砍树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-02 11:32:55 
 */
public class CutOffTreesForGolfEventSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int m;
    private int n;

    public int cutOffTree(List<List<Integer>> forest) {
        int res = 0;
        List<int[]> trees = new ArrayList<>();
        m = forest.size();
        n = forest.get(0).size();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            List<Integer> line = forest.get(i);
            for (int j = 0; j < n; j++) {
                int height = grid[i][j] = line.get(j);
                if (height > 1) {
                    int[] tree = {i, j, height};
                    trees.add(tree);
                }
            }
        }
        trees.sort((o1, o2) -> o1[2] - o2[2]);
        int[] pre = {0, 0, grid[0][0]};
        for (int i = 0; i < trees.size(); i++) {
            int[] cur = trees.get(i);
            int step = bfs(pre, cur, grid);
            if (step == -1) return -1;
            res += step;
            pre = cur;
        }
        return res;
    }

    int bfs(int[] pre, int[] target, int[][] grid) {
        if (pre[2] == 0) return -1;
        int[][] origin = grid;
        grid = new int[m][];
        for (int i = 0; i < m; i++) {
            grid[i] = Arrays.copyOf(origin[i], n);
        }
        Queue<int[]> pq = new ArrayDeque<>();
        pq.offer(pre);
        int step = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] cur = pq.poll();
                int x = cur[0];
                int y = cur[1];
                if (target[0] == x && target[1] == y) return step;
                if (x > 0 && grid[x - 1][y] != 0) {
                    pq.offer(new int[]{x - 1, y});
                    grid[x - 1][y] = 0;
                }
                if (x < m - 1 && grid[x + 1][y] != 0) {
                    pq.offer(new int[]{x + 1, y});
                    grid[x + 1][y] = 0;
                }
                if (y > 0 && grid[x][y - 1] != 0) {
                    pq.offer(new int[]{x, y - 1});
                    grid[x][y - 1] = 0;
                }
                if (y < n - 1 && grid[x][y + 1] != 0) {
                    pq.offer(new int[]{x, y + 1});
                    grid[x][y + 1] = 0;
                }
            }
            step++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
