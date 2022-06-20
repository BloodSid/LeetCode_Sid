package leetcode.editor.cn;
//Range模块是跟踪数字范围的模块。设计一个数据结构来跟踪表示为 半开区间 的范围并查询它们。 
//
// 半开区间 [left, right) 表示所有 left <= x < right 的实数 x 。 
//
// 实现 RangeModule 类: 
//
// 
// RangeModule() 初始化数据结构的对象。 
// void addRange(int left, int right) 添加 半开区间 [left, right)，跟踪该区间中的每个实数。添加与当前跟踪的
//数字部分重叠的区间时，应当添加在区间 [left, right) 中尚未跟踪的任何数字到该区间中。 
// boolean queryRange(int left, int right) 只有在当前正在跟踪区间 [left, right) 中的每一个实数时，才返
//回 true ，否则返回 false 。 
// void removeRange(int left, int right) 停止跟踪 半开区间 [left, right) 中当前正在跟踪的每个实数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["RangeModule", "addRange", "removeRange", "queryRange", "queryRange", 
//"queryRange"]
//[[], [10, 20], [14, 16], [10, 14], [13, 15], [16, 17]]
//输出
//[null, null, null, true, false, true]
//
//解释
//RangeModule rangeModule = new RangeModule();
//rangeModule.addRange(10, 20);
//rangeModule.removeRange(14, 16);
//rangeModule.queryRange(10, 14); 返回 true （区间 [10, 14) 中的每个数都正在被跟踪）
//rangeModule.queryRange(13, 15); 返回 false（未跟踪区间 [13, 15) 中像 14, 14.03, 14.17 这样
//的数字）
//rangeModule.queryRange(16, 17); 返回 true （尽管执行了删除操作，区间 [16, 17) 中的数字 16 仍然会被跟踪）
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= left < right <= 10⁹ 
// 在单个测试用例中，对 addRange 、 queryRange 和 removeRange 的调用总数不超过 10⁴ 次 
// 
// 👍 139 👎 0


import java.util.*;

/**
 * Range 模块
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-20 12:14:40 
 */
public class RangeModuleSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class RangeModule {

    // 键值对 {l, r} 表示一个区间
    private final TreeMap<Integer, Integer> intervals;

    public RangeModule() {
        intervals = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        // 最后一个 l <= left 的区间
        Map.Entry<Integer, Integer> entry = intervals.floorEntry(left);
        // 若没有这样的区间忽略这一步; 若 left > r 忽略这一步
        if (entry != null && left <= entry.getValue()) {
            // {l, r} 完全包含待添加的区间，不需要操作，直接返回
            if (right <= entry.getValue()) return;
                // l <= left <= r < right
            else {
                left = entry.getKey();
                intervals.remove(entry.getKey());
            }
        }
        // 遍历 {l, r} 之后的区间
        entry = intervals.higherEntry(left);
        while (entry != null && entry.getKey() <= right) {
            right = Math.max(right, entry.getValue());
            intervals.remove(entry.getKey());
            entry = intervals.higherEntry(entry.getKey());
        }
        intervals.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Map.Entry<Integer, Integer> floor = intervals.floorEntry(left);
        if (floor == null) return false;
        return right <= floor.getValue();
    }
    
    public void removeRange(int left, int right) {
        // 最后一个 l <= left 的区间
        Map.Entry<Integer, Integer> entry = intervals.floorEntry(left);
        // 若没有这样的区间忽略这一步; 若 left >= r 忽略这一步
        if (entry != null && left < entry.getValue()) {
            // {l, r} 完全包含待删除的区间
            if (right <= entry.getValue()) {
                intervals.remove(entry.getKey());
                if (left != entry.getKey()) intervals.put(entry.getKey(), left);
                if (right != entry.getKey()) intervals.put(right, entry.getValue());
                return;
            }
                // l <= left < r < right
            else {
                intervals.put(entry.getKey(), left);
            }
        }
        // 遍历 {l, r} 之后的区间
        entry = intervals.higherEntry(left);
        while (entry != null && entry.getKey() < right) {
            if (entry.getValue() <= right) {
                intervals.remove(entry.getKey());
            } else {
                intervals.remove(entry.getKey());
                intervals.put(right, entry.getValue());
                break;
            }
            entry = intervals.higherEntry(entry.getKey());
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
