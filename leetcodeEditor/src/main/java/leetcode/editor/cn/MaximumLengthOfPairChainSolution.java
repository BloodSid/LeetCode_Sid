package leetcode.editor.cn;
//给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。 
//
// 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。 
//
// 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。 
//
// 
//
// 示例： 
//
// 
//输入：[[1,2], [2,3], [3,4]]
//输出：2
//解释：最长的数对链是 [1,2] -> [3,4]
// 
//
// 
//
// 提示： 
//
// 
// 给出数对的个数在 [1, 1000] 范围内。 
// 
// 👍 241 👎 0


import java.util.*;

/**
 * 最长数对链
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-03 03:37:15 
 */
public class MaximumLengthOfPairChainSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[0]));
        int n = pairs.length;
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) temp = Math.max(temp, dp[j]);
            }
            dp[i] = temp + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
