package leetcode.editor.cn;

import java.util.*;

/**
 * 三数之和
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-05 00:21:12 
 */
public class ThreeSumSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        for (int i = 0; i < keys.length; i++) {
            int num1 = keys[i];
            int cnt1 = map.get(keys[i]);
            if (num1 == 0) {
                if (cnt1 >= 3) {
                    ans.add(Arrays.asList(0, 0, 0));
                }
            } else if (cnt1 >= 2 && map.containsKey(-2 * num1)) {
                ans.add(Arrays.asList(num1, num1, -2 * num1));
            }
            for (int j = i + 1; j < keys.length; j++) {
                int num3 = -keys[i] - keys[j];
                if (num3 > keys[j] && map.containsKey(num3)) {
                    ans.add(Arrays.asList(keys[i], keys[j], num3));
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
