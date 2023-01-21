/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * @author IronSid
 * @create 2021-06-30 0:30
 */
public class Solution {
    public int countSubstrings(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) {
            return s.length();
        }
        //初始化动态规划
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < dp.length - 1; i++) {
            int temp = s.charAt(i) == s.charAt(i + 1) ? 2 : 0;
            dp[i][i + 1] = temp;
        }

        //运算dp，并找出最大
        for (int i = dp.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < dp.length; j++) {
                //字母相等，且dp[i+1][j-1]不为零,则dp[i][j] 递增，否则为零
                if (dp[i + 1][j - 1] != 0 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        //输出
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] != 0) count++;
            }
        }
        return count;
    }
}
