package Contest0611.T1;

/**
 * @author IronSid
 * @since 2023-06-11 10:29
 */
public class Solution {
    public int findNonMinOrMax(int[] nums) {
        int min = 101;
        int max = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        for (int num : nums) {
            if (num != min && num != max) return num;
        }
        return -1;
    }
}
