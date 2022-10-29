package Contest1029.T3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author IronSid
 * @since 2022-10-29 22:27
 */
public class Solution {
    public int destroyTargets(int[] nums, int space) {
        TreeMap<Integer, Integer> f = new TreeMap<>();
        for (int num : nums) {
            f.put(num, f.getOrDefault(num, 0) + 1);
        }
        // 储存同余的 num 数量
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxCnt = 0;
        int minKey = 0;
        for (Integer key : f.descendingKeySet()) {
            int cnt = f.get(key) + dp.getOrDefault(key % space, 0);
            if (cnt >= maxCnt) {
                maxCnt = cnt;
                minKey = key;
            }
            dp.put(key % space, cnt);
        }
        return minKey;
    }
}
