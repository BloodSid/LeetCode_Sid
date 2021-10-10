package leetcode.editor.cn;
//给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。 
//
// 实现 SummaryRanges 类： 
//
// 
// 
// 
// SummaryRanges() 使用一个空数据流初始化对象。 
// void addNum(int val) 向数据流中加入整数 val 。 
// int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum"
//, "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
//[[], [1], [], [3], [], [7], [], [2], [], [6], []]
//输出：
//[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]],
// null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]
//
//解释：
//SummaryRanges summaryRanges = new SummaryRanges();
//summaryRanges.addNum(1);      // arr = [1]
//summaryRanges.getIntervals(); // 返回 [[1, 1]]
//summaryRanges.addNum(3);      // arr = [1, 3]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
//summaryRanges.addNum(7);      // arr = [1, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
//summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
//summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
//summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= val <= 104 
// 最多调用 addNum 和 getIntervals 方法 3 * 104 次 
// 
// 
// 
//
// 
//
// 进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办? 
// Related Topics 设计 二分查找 有序集合 
// 👍 143 👎 0


import java.util.*;

/**
 * 将数据流变为多个不相交区间
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-10 20:07:54
 */
public class DataStreamAsDisjointIntervalsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class SummaryRanges {
    TreeMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
        // 哨兵
        intervals.put(-2, -2);
        intervals.put(10002, 10002);
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> interval0 = intervals.floorEntry(val);
        Map.Entry<Integer, Integer> interval1 = intervals.ceilingEntry(val + 1);
        Integer l0 = interval0.getKey();
        Integer r0 = interval0.getValue();
        Integer l1 = interval1.getKey();
        Integer r1 = interval1.getValue();
        if (val >= l0 && val <= r0) {
            return;
        }
        if (val == r0 + 1 && val == l1 - 1) {
            intervals.remove(l1);
            intervals.put(l0, r1);
            return;
        }
        if (val == r0 + 1) {
            intervals.put(l0, val);
            return;
        }
        if (val == l1 - 1) {
            intervals.remove(l1);
            intervals.put(val, r1);
            return;
        }
        intervals.put(val, val);
    }

    public int[][] getIntervals() {
        int[][] ret = new int[intervals.size() - 2][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            if (index - 1 >= 0 && index - 1 < ret.length) {
                ret[index - 1][0] = entry.getKey();
                ret[index - 1][1] = entry.getValue();
            }
            index++;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
