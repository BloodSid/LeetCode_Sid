package leetcode.editor.cn;

import java.util.*;

/**
 * 键值映射
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-14 10:40:48
 */
public class MapSumPairsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MapSum {
    Map<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
