package Contest0925.T3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-09-25 11:23
 */
public class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] de = new int[n];
        int[] in = new int[n];
        for (int i = 0, dlen = 0, ilen = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] >= nums[i]) dlen++;
            else dlen = 1;
            if (i > 0 && nums[i - 1] <= nums[i]) ilen++;
            else ilen = 1;
            de[i] = dlen;
            in[i] = ilen;
        }
        for (int i = k; i < n - k; i++) {
            if (de[i - 1] >= k && in[i + k] >= k) res.add(i);
        }
        return res;
    }
}
