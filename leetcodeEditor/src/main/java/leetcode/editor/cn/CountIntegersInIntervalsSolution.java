package leetcode.editor.cn;

import java.util.*;

/**
 * 统计区间中的整数数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-15 22:55:31
 */
public class CountIntegersInIntervalsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class CountIntervals {

    TreeMap<Integer, Integer> intervals = new TreeMap<>();
    int sum = 0;

    public CountIntervals() {

    }

    public void add(int left, int right) {
        int delete = 0;
        right++;
        Iterator<Integer> it = intervals.subMap(left, true, right, true).keySet().iterator();
        Integer cur = null;
        while (it.hasNext()) {
            cur = it.next();
            delete += intervals.get(cur) - cur;
            right = Math.max(right, intervals.get(cur));
            it.remove();
        }
        Integer pre = intervals.lowerKey(left);
        if (pre != null && intervals.get(pre) >= left) {
            delete += intervals.get(pre) - pre;
            left = pre;
            right = Math.max(right, intervals.get(pre));
            intervals.remove(pre);
        }
        intervals.put(left, right);
        sum += right - left - delete;
    }

    public int count() {
        return sum;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
