package leetcode.editor.cn;
//给你一个以 (radius, xCenter, yCenter) 表示的圆和一个与坐标轴平行的矩形 (x1, y1, x2, y2) ，其中 (x1, y1
//) 是矩形左下角的坐标，而 (x2, y2) 是右上角的坐标。 
//
// 如果圆和矩形有重叠的部分，请你返回 true ，否则返回 false 。 
//
// 换句话说，请你检测是否 存在 点 (xi, yi) ，它既在圆上也在矩形上（两者都包括点落在边界上的情况）。 
//
// 
//
// 示例 1 ： 
// 
// 
//输入：radius = 1, xCenter = 0, yCenter = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
//输出：true
//解释：圆和矩形存在公共点 (1,0) 。
// 
//
// 示例 2 ： 
//
// 
//输入：radius = 1, xCenter = 1, yCenter = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
//输出：false
// 
//
// 示例 3 ： 
// 
// 
//输入：radius = 1, xCenter = 0, yCenter = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= radius <= 2000 
// -10⁴ <= xCenter, yCenter <= 10⁴ 
// -10⁴ <= x1 < x2 <= 10⁴ 
// -10⁴ <= y1 < y2 <= 10⁴ 
// 
//
// 👍 85 👎 0


/**
 * 圆和矩形是否有重叠
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-06-25 20:34:54 
 */
public class CircleAndRectangleOverlappingSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkOverlap(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
        // 圆心在矩形内
        if (xc >= x1 && xc <= x2 && yc >= y1 && yc <= y2) {
            return true;
        }
        // 圆心到角小于等于半径则有公共点
        int rSq = r * r;
        if ((disSq(xc, yc, x1, y1) <= rSq) || (disSq(xc, yc, x1, y2) <= rSq)
                || (disSq(xc, yc, x2, y1) <= rSq) || (disSq(xc, yc, x2, y2) <= rSq)) {
            return true;
        }
        // 角在圆外，则判断边上有无交点
        if (xc >= x1 && xc <= x2 && (Math.abs(yc - y1) <= r || Math.abs(yc - y2) <= r)) {
            return true;
        }
        if (yc >= y1 && yc <= y2 && (Math.abs(xc - x1) <= r || Math.abs(xc - x2) <= r)) {
            return true;
        }
        return false;
    }

    int disSq(int a, int b, int x, int y) {
        return (a - x) * (a - x) + (b - y) * (b - y);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
