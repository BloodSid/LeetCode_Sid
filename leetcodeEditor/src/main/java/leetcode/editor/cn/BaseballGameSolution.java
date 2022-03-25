package leetcode.editor.cn;

/**
 * 棒球比赛
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-26 00:10:29 
 */
public class BaseballGameSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calPoints(String[] ops) {
        int n = ops.length;
        int[] score = new int[n];
        int i = 0;
        for (String op : ops) {
            if (op.equals("+")) {
                score[i] = score[i - 1] + score[i - 2];
                i++;
            } else if (op.equals("D")) {
                score[i] = score[i - 1] << 1;
                i++;
            } else if (op.equals("C")) {
                i--;
                score[i] = 0;
            } else {
                score[i] = Integer.parseInt(op);
                i++;
            }
        }
        int res = 0;
        for (int i1 = 0; i1 < i; i1++) {
            res += score[i1];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
