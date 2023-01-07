package Contest0107.T3;

/**
 * @author IronSid
 * @since 2023-01-07 22:35
 */
public class Solution {
    public int xorBeauty(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
