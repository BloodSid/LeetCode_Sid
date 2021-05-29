/**
 * @author IronSid
 * @create 2021-05-29 8:33
 */
public class Solution {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                //dp[i - 1][x - 1] 递增 dp[i][j - x]递减 找出两者相等的点,
                //即是max(dp[i - 1][x - 1], dp[i][j - x])的最小点
                int front = 1;
                int behind = j;
                int x = (front + behind) / 2;
                while (front < behind - 1) {
                    int t1 = dp[i - 1][x - 1];
                    int t2 = dp[i][j - x];
                    if(t1<t2){
                        front=x;
                    }
                    if(t1>t2){
                        behind=x;
                    }
                    if(t1==t2){
                        front=behind=x;
                    }
                    x = (front + behind) / 2;
                }
                dp[i][j] =Math.min(Math.max(dp[i - 1][x - 1], dp[i][j - x]),
                                    Math.max(dp[i - 1][x], dp[i][j - x - 1])
                ) + 1;
            }
        }
        return dp[k][n];

    }

    public static void main(String[] args) {


    }

}