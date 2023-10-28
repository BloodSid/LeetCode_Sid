package Contest1028.T4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author IronSid
 * @since 2023-10-28 22:38
 */
public class Solution {

    public static final int M = (int) (1e9 + 7);

    public int sumCounts(int[] nums) {
        long res = 0;
        int n = nums.length;
        HashMap<Integer, Integer> last = new HashMap<>();
        long[] p1 = new long[n + 1], p2 = new long[n + 1];

        for (int i = 0; i < n; i++) {
            int l = last.getOrDefault(nums[i], -1);
            p1[i + 1] = (p1[i] + i - l) % M;
            p2[i + 1] = ((p2[i] + 2 * (p1[i] - 1 - p1[l + 1]) + i - l) % M + M) % M;
            res = (res + p2[i +1]) % M;
            last.put(nums[i], i);
        }
        System.out.println(Arrays.toString(p2));
        return (int) (res % M);
    }
}
