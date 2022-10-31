package Contest1029.T3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-10-29 22:27
 */
public class Solution {
    public int destroyTargets(int[] nums, int space) {
        // 同余分组
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int key = num % space;
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(num);
        }
        int max = 0;
        int ans = 0;
        for (List<Integer> value : map.values()) {
            int m = value.size();
            int min = Integer.MAX_VALUE;
            for (Integer v : value) {
                min = Math.min(min, v);
            }
            if (m > max || m == max && min < ans) {
                max = m;
                ans = min;
            }
        }
        return ans;
    }
}
