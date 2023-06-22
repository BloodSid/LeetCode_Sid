package leetcode.editor.cn;
//在 `n*m` 大小的棋盘中，有黑白两种棋子，黑棋记作字母 `"X"`, 白棋记作字母 `"O"`，空余位置记作 `"."`。当落下的棋子与其他相同颜色的棋
//子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
//
//![1.gif](https://pic.leetcode-cn.com/1630396029-eTgzpN-6da662e67368466a96d203
//f67bb6e793.gif){:height=170px}![2.gif](https://pic.leetcode-cn.com/1630396240-
//nMvdcc-8e4261afe9f60e05a4f740694b439b6b.gif){:height=170px}![3.gif](https://pic.
//leetcode-cn.com/1630396291-kEtzLL-6fcb682daeecb5c3f56eb88b23c81d33.gif){:height=170
//px}
//
//「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 `chessboard`。若下一步可放置一枚黑棋，请问选手最多能翻转
//多少枚白棋。
//
//**注意：**
//- 若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 **继续** 翻转白棋
//- 输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
//
//**示例 1：**
//
//> 输入：`chessboard = ["....X.","....X.","XOOO..","......","......"]`
//>
//> 输出：`3`
//>
//> 解释：
//> 可以选择下在 `[2,4]` 处，能够翻转白方三枚棋子。
//
//**示例 2：**
//
//> 输入：`chessboard = [".X.",".O.","XO."]`
//>
//> 输出：`2`
//>
//> 解释：
//> 可以选择下在 `[2,2]` 处，能够翻转白方两枚棋子。
//> ![2126c1d21b1b9a9924c639d449cc6e65.gif](https://pic.leetcode-cn.com/16266832
//55-OBtBud-2126c1d21b1b9a9924c639d449cc6e65.gif)
//
//**示例 3：**
//
//> 输入：`chessboard = [".......",".......",".......","X......",".O.....","..O....
//","....OOX"]`
//>
//> 输出：`4`
//>
//> 解释：
//> 可以选择下在 `[6,3]` 处，能够翻转白方四枚棋子。
//> ![803f2f04098b6174397d6c696f54d709.gif](https://pic.leetcode-cn.com/16303937
//70-Puyked-803f2f04098b6174397d6c696f54d709.gif)
//
//**提示：**
//- `1 <= chessboard.length, chessboard[i].length <= 8`
//- `chessboard[i]` 仅包含 `"."、"O"` 和 `"X"`
//
// 👍 69 👎 0


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 黑白翻转棋
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-06-22 21:28:00 
 */
public class FHi6rVSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int[][] DIRS = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int flipChess(String[] chessboard) {
        int m = chessboard.length;
        int n = chessboard[0].length();
        char[][] g = new char[m][];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chessboard[i].charAt(j) != '.') continue;
                for (int i1 = 0; i1 < m; i1++) g[i1] = chessboard[i1].toCharArray();
                Deque<int[]> q = new ArrayDeque<>();
                int cnt = 0;
                q.offer(new int[]{i, j});
                g[i][j] = 'X';
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cx = cur[0], cy = cur[1];
                    for (int[] dir : DIRS) {
                        int dx = dir[0], dy = dir[1];
                        for (int tx = cx + dx, ty = cy + dy;
                             tx >= 0 && tx < m && ty >= 0 && ty < n; tx += dx, ty += dy) {
                            if (g[tx][ty] == '.') {
                                // 有空白位置就中断
                                break;
                            } else if (g[tx][ty] == 'X') {
                                // 找到另一端的黑棋，将两端黑棋中间的所有白棋加入队列
                                for (int x = cx + dx, y = cy + dy;
                                     (dx == 0 || x != tx) && (dy == 0 || y != ty); x += dx, y += dy) {
                                    q.offer(new int[]{x, y});
                                    g[x][y] = 'X';
                                    cnt++;
                                }
                                break;
                            }
                            // 白棋则继续找
                        }
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
