package leetcode.editor.cn;

/**
 * 最大三角形面积
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-15 00:08:32 
 */
public class LargestTriangleAreaSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double largestTriangleArea(int[][] points) {
        double largest = 0.0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1],
                            x3 = points[k][0], y3 = points[k][1];
                    int a1 = x3 - x1, b1 = y3 - y1;
                    int a2 = x3 - x2, b2 = y3 - y2;
                    double area = Math.abs(0.5 * (a1 * b2 - a2 * b1));
                    largest = Math.max(largest, area);
                }
            }
        }
        return largest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
