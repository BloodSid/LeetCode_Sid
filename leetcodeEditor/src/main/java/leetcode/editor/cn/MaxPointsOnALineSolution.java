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


import java.util.HashMap;

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
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int[] simplest = simplify(points[i][1] - points[j][1], points[i][0] - points[j][0]);
                int key = (simplest[0] << 16) | simplest[1];
                int cnt = map.getOrDefault(key, 0) + 1;
                map.put(key, cnt);
                max = Math.max(max, cnt + 1);
            }
        }
        return max;
    }

    // 简化分数 a / b
    int[] simplify(int a, int b) {
        if (a == 0) return new int[]{0, 1};
        if (b == 0) return new int[]{1, 0};
        boolean negative = a > 0 != b > 0;
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        // 规定分母必须为正
        return new int[]{negative ? -a : a, b};
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
