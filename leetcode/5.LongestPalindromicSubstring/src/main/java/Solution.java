/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author IronSid
 * @create 2021-06-30 0:39
 */
public class Solution {
    public String longestPalindrome(String s){
        if(s==null) return "";
        if (s.length() <= 1) {
            return s;
        }
        //初始化动态规划
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        int max = 1;
        int start=0,end=0;
        for (int i = 0; i < dp.length - 1; i++) {
            int temp = s.charAt(i) == s.charAt(i + 1) ? 2 : 0;
            dp[i][i + 1] = temp;
            if(temp>max){
                max=temp;
                start=i;
                end=i+1;
            }
        }

        //运算dp，并找出最大
        for (int i = dp.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < dp.length; j++) {
                //字母相等，且dp[i+1][j-1]不为零,则dp[i][j] 递增，否则为零
                if (dp[i + 1][j - 1] != 0 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if(dp[i][j]>max){
                        max = dp[i][j];
                        start = i;
                        end = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        //输出
        return s.substring(start,end+1);
    }
}
