package Contest0513.T2;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-05-13 22:29
 */
public class Solution {
    public int matrixSum(int[][] nums) {
        int score = 0;
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int m = nums.length, n = nums[0].length;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, nums[i][j]);
            }
            score += max;
        }
        return score;
    }
}
