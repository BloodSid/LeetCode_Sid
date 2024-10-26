package Contest0609.T3;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-06-09 10:43
 */
public class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int N = 2000;
        boolean[] res = new boolean[2 * N + 1];
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        int max = rewardValues[n - 1];
        for (int i : rewardValues) {
            res[i] = true;
            for (int j = 1; j < i; j++) {
                if (res[j]) {
                    res[i + j] = true;
                    max = Math.max(max, i + j);
                }
            }
        }
        return max;
    }
}
