package Contest0218.T2;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2024-02-18 10:30
 */
public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> f = new HashSet<>();
        for (int i : arr1) {
            for (; i > 0; i /= 10) {
                f.add(i);
            }
        }
        int res =  0;
        for (int i : arr2) {
            for (; i > 0; i /= 10) {
                if (f.contains(i)) {
                    res = Math.max(res, (String.valueOf(i)).length());
                    break;
                }
            }
        }
        return res;
    }
}
