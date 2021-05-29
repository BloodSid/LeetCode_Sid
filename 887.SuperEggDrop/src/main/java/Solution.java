/**
 * @author IronSid
 * @create 2021-05-29 8:33
 */
public class Solution {
    public int superEggDrop(int k, int n) {
        //dp[k][t] 表示k个鸡蛋t次操作最多能测试多少层,t最大为n
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[1][i] = i;
        }
        for (int i = 1; i <= k; i++) {
            dp[i][1] = 1;
        }

        for (int i = 2; i <= k; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i-1][j-1]+1+dp[i][j-1];
                if(i==k&&dp[i][j]>=n)
                    return j;
            }

        }

        return n;

    }

    public static void main(String[] args) {


    }

}