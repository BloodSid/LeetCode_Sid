package Contest0101.T2;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2023-01-01 10:36
 */
public class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            for (int factor = 2; factor <= num / factor; factor++) {
                while (num % factor == 0) {
                    set.add(factor);
                    num /= factor;
                }
            }
            if (num != 1) set.add(num);
        }
        return set.size();
    }
 }
