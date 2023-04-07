package leetcode.editor.cn;

import java.util.*;

/**
 * 我的日程安排表 I
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-14 00:41:01
 */
public class MyCalendarISolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MyCalendar {
    // TODO 线段树

    private final TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer pre = map.floorKey(start), suf = map.ceilingKey(start);
        if (pre != null && start < map.get(pre)) return false;
        if (suf != null && end > suf) return false;
        map.put(start, end);
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
