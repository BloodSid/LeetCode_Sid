package leetcode.editor.cn;

/**
 * 得分最高的最小轮调
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-09 00:10:02
 */
public class SmallestRotationWithHighestScoreSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        // 差分数组
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[(i + 1) % n]++;
            diffs[(i - nums[i] + 1 + n) % n]--;
        }
        int maxScore = Integer.MIN_VALUE;
        int score = 0;
        int k = 0;
        // 求差分数组的前缀和，依次得到不同的 k 的得分和 k = 0 的得分的相对大小
        for (int i = 0; i < n; i++) {
            score += diffs[i];
            if (score > maxScore) {
                maxScore = score;
                k = i;
            }
        }
        return k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
