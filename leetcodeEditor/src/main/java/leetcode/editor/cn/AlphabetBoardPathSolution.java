package leetcode.editor.cn;
//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。 
//
// 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。 
//
// 
//
// 我们可以按下面的指令规则行动： 
//
// 
// 如果方格存在，'U' 意味着将我们的位置上移一行； 
// 如果方格存在，'D' 意味着将我们的位置下移一行； 
// 如果方格存在，'L' 意味着将我们的位置左移一列； 
// 如果方格存在，'R' 意味着将我们的位置右移一列； 
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。 
// 
//
// （注意，字母板上只存在有字母的位置。） 
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
// 
//
// 示例 2： 
//
// 
//输入：target = "code"
//输出："RR!DDRR!UUL!R!"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// target 仅含有小写英文字母。 
// 
// 👍 51 👎 0


/**
 * 字母板上的路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-02-12 01:16:13 
 */
public class AlphabetBoardPathSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int px = 0, py = 0;
        for (char c : target.toCharArray()) {
            int[] cur = getXY(c);
            int cx = cur[0], cy = cur[1];
            if (c == 'z') {
                // 从其他字母到 'z' 得先左右，再上下
                go(cy - py, true, sb);
                go(cx - px, false, sb);
            } else {
                // 到其他字母先可以通用先上下，再左右
                go(cx - px, false, sb);
                go(cy - py, true, sb);
            }
            sb.append('!');
            px = cx;
            py = cy;
        }
        return sb.toString();
    }

    void go(int d, boolean LR, StringBuilder sb) {
        if (d < 0) {
            // 向左向上
            for (int i = 0; i < -d; i++) {
                if (LR) sb.append('L');
                else sb.append('U');
            }
        } else {
            // 向右向下
            for (int i = 0; i < d; i++) {
                if (LR) sb.append('R');
                else sb.append('D');
            }
        }
    }

    int[] getXY(char c) {
        int t = c - 'a';
        return new int[]{t / 5, t % 5};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
