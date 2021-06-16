import java.util.Arrays;

/**
 * @author IronSid
 * @create 2021-06-16 17:58
 */
public class Solution {

    public boolean stoneGame(int[] piles) {
        //涂格子分析，可知先手必胜，即无需运算
        //return true;
        int len = piles.length;
        int[] dp = Arrays.copyOf(piles,len);
        //定义二维数组 dp，其行数和列数都等于石子的堆数，dp[i][j]表示当剩下的石子堆为下标 i 到下标 j 时，
        //当前玩家与另一个玩家的石子数量之差的最大值，注意当前玩家不一定是先手
        //状态转移方程dp[i][j]=max(piles[i]−dp[i+1][j],piles[j]−dp[i][j−1])
        //dp[i][j] 的值只和 dp[i+1][j] 与 dp[i][j−1] 有关
        //因此可以使用一维数组代替二维数组，对空间进行优化
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                dp[j]=Math.max(piles[i]-dp[j],piles[j]-dp[j-1]);
            }
        }
        return dp[len-1]>0;

    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {7, 7, 12, 16, 41, 48, 41, 48, 11, 9, 34, 2, 44, 30, 27, 12, 11, 39, 31, 8, 23, 11, 47, 25, 15, 23, 4, 17, 11, 50, 16, 50, 38, 34, 48, 27, 16, 24, 22, 48, 50, 10, 26, 27, 9, 43, 13, 42, 46, 24};
        System.out.println(a.length);
        System.out.println(s.stoneGame(a));
    }
}
