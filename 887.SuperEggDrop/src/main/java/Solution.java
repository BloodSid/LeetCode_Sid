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
                int dp_i_j = n;
                for (int x = 1; x <= j; x++) {
                    int temp = Math.max(dp[i - 1][x - 1], dp[i][j - x]);
//                    System.out.println("k:" + i + " n:" + j + " x:" + (x) + " dp:" + (temp + 1));
                    if (temp <= dp_i_j) {
                        dp_i_j = temp;
//                        if (x == j)
//                            System.out.println("k:"+i+" n:"+j +" x:"+(x)+" dp:"+ (dp_i_j+1));
                    } else {
//                        System.out.println("k:"+i+" n:"+j +" x:"+(x-1)+" dp:"+ (dp_i_j+1));
                        break;
                    }
                }
                dp[i][j] = dp_i_j + 1;
            }
        }
        return dp[k][n];

    }

}