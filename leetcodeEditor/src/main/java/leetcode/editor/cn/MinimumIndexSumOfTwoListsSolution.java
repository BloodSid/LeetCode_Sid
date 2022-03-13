package leetcode.editor.cn;

import java.util.*;

/**
 * 两个列表的最小索引总和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-14 00:04:14
 */
public class MinimumIndexSumOfTwoListsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int l1 = list1.length, l2 = list2.length;
        // 让list1更长
        if (l1 < l2) {
            return findRestaurant(list2, list1);
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < l1; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < l2; i++) {
            if (map.containsKey(list2[i])) {
                int sum = i + map.get(list2[i]);
                if (sum < minSum) {
                    minSum = sum;
                    res.clear();
                    res.add(list2[i]);
                } else if (sum == minSum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
