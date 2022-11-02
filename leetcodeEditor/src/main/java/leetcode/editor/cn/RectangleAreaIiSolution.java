package leetcode.editor.cn;
//我们给出了一个（轴对齐的）二维矩形列表 rectangles 。 对于 rectangle[i] = [xi1, yi1, xi2, yi2]，表示第 i 
//个矩形的坐标， (xi1, yi1) 是该矩形 左下角 的坐标， (xi2, yi2) 是该矩形 右上角 的坐标。 
//
// 计算平面中所有 rectangles 所覆盖的 总面积 。任何被两个或多个矩形覆盖的区域应只计算 一次 。 
//
// 返回 总面积 。因为答案可能太大，返回 10⁹ + 7 的 模 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：rectangles = [[0,0,2,2],[1,0,2,3],[1,0,3,1]]
//输出：6
//解释：如图所示，三个矩形覆盖了总面积为6的区域。
//从(1,1)到(2,2)，绿色矩形和红色矩形重叠。
//从(1,0)到(2,3)，三个矩形都重叠。
// 
//
// 示例 2： 
//
// 
//输入：rectangles = [[0,0,1000000000,1000000000]]
//输出：49
//解释：答案是 10¹⁸ 对 (10⁹ + 7) 取模的结果， 即 49 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= rectangles.length <= 200 
// rectanges[i].length = 4 
// 0 <= xi1, yi1, xi2, yi2 <= 10⁹ 
// 矩形叠加覆盖后的总面积不会超越 2^63 - 1 ，这意味着可以用一个 64 位有符号整数来保存面积结果。 
// 
// 👍 230 👎 0


import java.util.*;

/**
 * 矩形面积 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-03 17:04:01 
 */
public class RectangleAreaIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int rectangleArea(int[][] rectangles) {
        HashSet<Integer> xSet = new HashSet<>();
        for (int[] rectangle : rectangles) {
            int x1 = rectangle[0], x2 = rectangle[2];
            xSet.add(x1);
            xSet.add(x2);
        }
        Integer[] xList = xSet.toArray(new Integer[0]);
        Arrays.sort(xList);
        long sum = 0;
        for (int i = 0; i < xList.length - 1; i++) {
            int l = xList[i], r = xList[i + 1];
            long diff = r - l;
            List<int[]> intervals = new ArrayList<>();
            for (int[] rectangle : rectangles) {
                int x1 = rectangle[0], y1 = rectangle[1], x2 = rectangle[2], y2 = rectangle[3];
                if (x1 <= l && x2 >= r) {
                    intervals.add(new int[]{y1, y2});
                }
            }
            intervals.sort((o1, o2) -> o1[0] - o2[0]);
            // 合并区间
            LinkedList<int[]> merged = new LinkedList<>();
            for (int[] interval : intervals) {
                if (!merged.isEmpty() && merged.getLast()[1] >= interval[0]) {
                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                } else {
                    merged.add(interval);
                }
            }
            // 计算合并后的长度
            long union = 0;
            for (int[] interval : merged) {
                union += interval[1] - interval[0];
            }
            sum += union * diff;
        }
        return (int) (sum % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
