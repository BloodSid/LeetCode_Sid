package leetcode.editor.cn;
//矩形蛋糕的高度为 h 且宽度为 w，给你两个整数数组 horizontalCuts 和 verticalCuts，其中： 
//
// 
// horizontalCuts[i] 是从矩形蛋糕顶部到第 i 个水平切口的距离 
// verticalCuts[j] 是从矩形蛋糕的左侧到第 j 个竖直切口的距离 
// 
//
// 请你按数组 horizontalCuts 和 verticalCuts 中提供的水平和竖直位置切割后，请你找出 面积最大 的那份蛋糕，并返回其 面积 。由
//于答案可能是一个很大的数字，因此需要将结果 对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
//输出：4 
//解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色的那份蛋糕面积最大。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
//输出：6
//解释：上图所示的矩阵蛋糕中，红色线表示水平和竖直方向上的切口。切割蛋糕后，绿色和黄色的两份蛋糕面积最大。 
//
// 示例 3： 
//
// 
//输入：h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 2 <= h, w <= 10⁹ 
// 1 <= horizontalCuts.length <= min(h - 1, 10⁵) 
// 1 <= verticalCuts.length <= min(w - 1, 10⁵) 
// 1 <= horizontalCuts[i] < h 
// 1 <= verticalCuts[i] < w 
// 题目数据保证 horizontalCuts 中的所有元素各不相同 
// 题目数据保证 verticalCuts 中的所有元素各不相同 
// 
//
// 👍 65 👎 0


import java.util.Arrays;

/**
 * 切割后面积最大的蛋糕
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-10-27 10:52:15 
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCutsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        return (int) ((long) maxSegment(0, h, horizontalCuts) * maxSegment(0, w, verticalCuts) % ((int) 1e9 + 7));
    }

    private int maxSegment(int min, int max, int[] cuts) {
        int res = 0;
        int n = cuts.length;
        Arrays.sort(cuts);
        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, cuts[i+1] -cuts[i]);
        }
        res = Math.max(res, cuts[0] - min);
        res = Math.max(res, max - cuts[n - 1]);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
