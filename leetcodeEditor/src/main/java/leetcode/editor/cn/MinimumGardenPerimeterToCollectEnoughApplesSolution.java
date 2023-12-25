package leetcode.editor.cn;
//给你一个用无限二维网格表示的花园，每一个 整数坐标处都有一棵苹果树。整数坐标 (i, j) 处的苹果树有 |i| + |j| 个苹果。 
//
// 你将会买下正中心坐标是 (0, 0) 的一块 正方形土地 ，且每条边都与两条坐标轴之一平行。 
//
// 给你一个整数 neededApples ，请你返回土地的 最小周长 ，使得 至少 有 neededApples 个苹果在土地 里面或者边缘上。 
//
// |x| 的值定义为： 
//
// 
// 如果 x >= 0 ，那么值为 x 
// 如果 x < 0 ，那么值为 -x 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：neededApples = 1
//输出：8
//解释：边长长度为 1 的正方形不包含任何苹果。
//但是边长为 2 的正方形包含 12 个苹果（如上图所示）。
//周长为 2 * 4 = 8 。
// 
//
// 示例 2： 
//
// 
//输入：neededApples = 13
//输出：16
// 
//
// 示例 3： 
//
// 
//输入：neededApples = 1000000000
//输出：5040
// 
//
// 
//
// 提示： 
//
// 
// 1 <= neededApples <= 10¹⁵ 
// 
//
// 👍 62 👎 0


/**
 * 收集足够苹果的最小花园周长
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-12-25 09:20:06 
 */
public class MinimumGardenPerimeterToCollectEnoughApplesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumPerimeter(long neededApples) {
        // 二分右上角的坐标
        long l = 0;
        long r = (long) 1e5;
        while (l <= r) {
            long mid = l + r >> 1;
            // 计算右上角坐标 (mid, mid) 的正方形范围内多少苹果
            long cnt = (2 * mid + 1) * mid * (mid + 1) * 2;
            if (cnt >= neededApples) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l * 8;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
