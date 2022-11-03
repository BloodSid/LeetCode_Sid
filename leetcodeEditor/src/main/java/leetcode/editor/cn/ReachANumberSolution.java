package leetcode.editor.cn;
//在一根无限长的数轴上，你站在0的位置。终点在target的位置。 
//
// 你可以做一些数量的移动 numMoves : 
//
// 
// 每次你可以选择向左或向右移动。 
// 第 i 次移动（从 i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。 
// 
//
// 给定整数 target ，返回 到达目标所需的 最小 移动次数(即最小 numMoves ) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: target = 2
//输出: 3
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 -1 。
//第三次移动，从 -1 到 2 。
// 
//
// 示例 2: 
//
// 
//输入: target = 3
//输出: 2
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 3 。
// 
//
// 
//
// 提示: 
//
// 
// -10⁹ <= target <= 10⁹ 
// target != 0 
// 
// 👍 194 👎 0


/**
 * 到达终点数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-04 00:06:47 
 */
public class ReachANumberSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reachNumber(int target) {
        // x 和 -x 的结果相同
        target = Math.abs(target);
        /* 走 i 步，所有能到达的位置一定在全往左走或者全往右走的两侧终点之间。若改变其中任意步，位置的改变量一定是个偶数，故其他可
        达点和最值点同奇偶
         */
        int l = 1, r = (int) 1e5;
        while (l < r) {
            int mid = l + r >> 1;
            // 等差数列求和，得到最值点位置
            if ((long) mid * (mid + 1) / 2 >= Math.abs(target)) r = mid;
            else l = mid + 1;
        }
        // 求出满足同奇偶条件的最小结果
        for (int i = l; ;i++) {
            if ((i * (i + 1) / 2) % 2 == target % 2) return i;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
