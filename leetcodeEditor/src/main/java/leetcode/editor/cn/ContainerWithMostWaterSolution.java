package leetcode.editor.cn;

/**
 * 盛最多水的容器
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-05 22:57:03
 */
public class ContainerWithMostWaterSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int leftH = height[l], rightH = height[r];
            maxArea = Math.max(maxArea, Math.min(leftH, rightH) * (r - l));
            // 将较短的一边向内移动。长的一边向内移动，容积一定变小，短的一边向内移动，溶剂可能变大。
            if (height[l] < height[r]) {
                for (; l < r && height[l] <= leftH; l++) {}
            } else {
                for (; l < r && height[r] <= rightH; r--) {}
            }
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
