package leetcode.editor.cn;

/**
 * 考试的最大困扰度
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-29 08:24:46 
 */
public class MaximizeTheConfusionOfAnExamSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private char[] c;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        c = answerKey.toCharArray();
        return Math.max(getCnt('T', k), getCnt('F', k));
    }

    // ch 表示被改的一种结果, 返回最大长度
    int getCnt(char ch, int k) {
        int max = 0;
        int cnt = 0;
        for (int i = 0, j = 0; j < c.length; i++) {
            while (j < c.length) {
                if (c[j] == ch) {
                    if (cnt == k) break;
                    cnt++;
                }
                j++;
            }
            max = Math.max(max, j - i);
            if (c[i] == ch) {
                cnt--;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
