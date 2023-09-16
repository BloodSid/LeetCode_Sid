package Contest0916.T1;

import java.util.List;

/**
 * @author IronSid
 * @since 2023-09-16 22:21
 */
public class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int j = 1;
            for (int t = n - i; j < n; j++) {
                if (nums.get((t + j - 1) % n) > nums.get((t + j) % n)) break;
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
}
