package Contest1016.T2;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-10-16 11:12
 */
public class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            set.add(num);
            sb.setLength(0);
            sb.append(num);
            sb.reverse();
            set.add(Integer.parseInt(sb.toString()));
        }
        return set.size();
    }
}
