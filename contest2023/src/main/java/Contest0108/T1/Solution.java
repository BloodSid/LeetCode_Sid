package Contest0108.T1;

/**
 * @author IronSid
 * @since 2023-01-08 10:28
 */
public class Solution {
    public int maximumCount(int[] nums) {
        int pos = 0, neg = 0;
        for (int num : nums) {
            if (num > 0) pos++;
            else if (num < 0) neg++;
        }
        return Math.max(pos, neg);
    }
}
