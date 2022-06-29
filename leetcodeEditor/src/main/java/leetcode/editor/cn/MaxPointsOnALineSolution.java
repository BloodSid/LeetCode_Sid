package leetcode.editor.cn;
//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// points 中的所有点 互不相同 
// 
// 👍 418 👎 0


/**
 * 直线上最多的点数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 22:49:44 
 */
public class MaxPointsOnALineSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) return 1;
        int max = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    if (isOnLine(points[i], points[j], points[k])) {
                        cnt++;
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    boolean isOnLine(int[] i, int[] j, int[] k) {
        return (i[0] - j[0]) * (i[1] - k[1]) == (i[0] - k[0]) * (i[1] - j[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
