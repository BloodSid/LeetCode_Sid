package Contest0303.T1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2024-03-03 10:34
 */
public class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> a1 = new ArrayList<>(), a2 = new ArrayList<>();
        a1.add(nums[0]);
        a2.add(nums[1]);
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            if (a1.get(a1.size() - 1) >= a2.get(a2.size() - 1)) {
                a1.add(nums[i]);
            } else {
                a2.add(nums[i]);
            }
        }
        int[] res = new int[n];
        int ri = 0;
        for (Integer i : a1) res[ri++] = i;
        for (Integer i : a2) res[ri++] = i;
        return res;
    }
}
