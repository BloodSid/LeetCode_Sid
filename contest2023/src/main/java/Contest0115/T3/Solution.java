package Contest0115.T3;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2023-01-15 10:20
 */
public class Solution {
    public long countGood(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 维护窗口内满足要求的数对数量
        int cnt = 0;
        long res = 0;
        for (j = 0; j < n; j++) {
            int y = nums[j];
            int f = map.getOrDefault(y, 0);
            cnt += f;
            map.put(y, f + 1);
            while (cnt >= k && i < j) {
                int x = nums[i];
                f = map.get(x);
                cnt -= f - 1;
                map.put(x, f - 1);
                i++;
            }
            res += i;
        }
        return res;
    }
}
