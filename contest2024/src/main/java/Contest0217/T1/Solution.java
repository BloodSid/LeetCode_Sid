package Contest0217.T1;

/**
 * @author IronSid
 * @since 2024-02-17 22:02
 */
public class Solution {
    public int maxOperations(int[] nums) {
        int i = 2;
        int sum = nums[0] + nums[1];
        while (i + 1 < nums.length) {
            if (nums[i] + nums[i + 1] != sum) {
                break;
            }
            i += 2;
        }
        return i / 2;
    }
}
