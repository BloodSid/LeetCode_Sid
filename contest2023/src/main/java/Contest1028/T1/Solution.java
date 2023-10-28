package Contest1028.T1;

import java.util.HashSet;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-10-28 22:33
 */
public class Solution {

    public static final int M = (int) (1e9 + 7);

    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums.get(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(a[j]);
                res += (long) set.size() * set.size();
                res %= M;
            }
        }
        return (int) (res % M);
    }
}
