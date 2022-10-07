package Contest1007.T3;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-10-07 14:56
 */
public class Solution {
    public int beautifulBouquet(int[] flowers, int cnt) {
        HashMap<Integer, Integer> f = new HashMap<>();
        int l = 0, r = 0;
        int res = 0;
        for (; r < flowers.length; r++) {
            f.put(flowers[r], f.getOrDefault(flowers[r], 0) + 1);
            while (f.get(flowers[r]) > cnt) {
                f.put(flowers[l], f.get(flowers[l]) - 1);
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}
