package leetcode.editor.cn;
//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的欧式距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
//
// 👍 296 👎 0


import java.util.*;

/**
 * 回旋镖的数量
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-01-08 17:52:37 
 */
public class NumberOfBoomerangsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] p1 : points) {
            // 记录其他点到 p1 的频率
            HashMap<Integer, Integer> f = new HashMap<>();
            for (int[] p2 : points) {
                int d = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                if (d != 0) {
                    f.merge(d, 1, Integer::sum);
                }
            }
            for (Integer m : f.values()) {
                res += m * (m - 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
