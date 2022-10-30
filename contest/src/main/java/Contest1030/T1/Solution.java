package Contest1030.T1;

/**
 * @author IronSid
 * @since 2022-10-30 10:29
 */
public class Solution {
    public int averageValue(int[] nums) {
        int cnt = 0;
        int sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                cnt++;
                sum += num;
            }
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}
