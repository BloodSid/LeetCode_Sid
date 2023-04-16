package Contest0416.T2;

/**
 * @author IronSid
 * @since 2023-04-16 10:30
 */
public class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        // 最大分数
        int max = 0;
        int res = Integer.MAX_VALUE;
        for (int divisor : divisors) {
            int cnt = 0;
            for (int num : nums) {
                if (num % divisor == 0) cnt++;
            }
            if (cnt > max || cnt == max && divisor < res) {
                max = cnt;
                res = divisor;
            }
        }
        return res;
    }
}