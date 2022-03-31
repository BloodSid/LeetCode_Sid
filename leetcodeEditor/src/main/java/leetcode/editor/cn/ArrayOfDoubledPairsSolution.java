package leetcode.editor.cn;

import java.util.*;

/**
 * 二倍数对数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-01 01:23:03
 */
public class ArrayOfDoubledPairsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        while (!map.isEmpty()) {
            int k = map.firstKey();
            int v = map.get(k);
            int v2 = map.getOrDefault(k << 1, 0);
            if (v2 > v) {
                map.put(k << 1, v2 - v);
                map.remove(k);
            } else if (v2 == v) {
                map.remove(k);
                map.remove(k << 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
