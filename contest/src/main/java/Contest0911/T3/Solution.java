package Contest0911.T3;

import java.util.TreeMap;

/**
 * @author IronSid
 * @since 2022-09-11 10:41
 */
public class Solution {
    public int minGroups(int[][] intervals) {
        TreeMap<Integer, Integer> pre = new TreeMap<>();
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1] + 1;
            pre.put(start, pre.getOrDefault(start, 0) + 1);
            pre.put(end, pre.getOrDefault(end, 0) - 1);
        }
        int max = 0, cnt = 0;
        for (Integer key : pre.keySet()) {
            cnt += pre.get(key);
            max = Math.max(max, cnt);
        }
        return max;
    }
}
