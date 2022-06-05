package leetcode.editor.cn;
//给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。 
//
// 实现 Solution 类: 
//
// 
// Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置
// (x_center, y_center) 初始化对象 
// randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//["Solution","randPoint","randPoint","randPoint"]
//[[1.0, 0.0, 0.0], [], [], []]
//输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
//解释:
//Solution solution = new Solution(1.0, 0.0, 0.0);
//solution.randPoint ();//返回[-0.02493，-0.38077]
//solution.randPoint ();//返回[0.82314,0.38945]
//solution.randPoint ();//返回[0.36572,0.17248] 
//
// 
//
// 提示： 
//
// 
// 0 < radius <= 10⁸ 
// -10⁷ <= x_center, y_center <= 10⁷ 
// randPoint 最多被调用 3 * 10⁴ 次 
// 
// 👍 91 👎 0


import java.util.*;

/**
 * 在圆内随机生成点
 *
 * @author IronSid
 * @since 2022-06-05 09:59:44 
 * @version 1.0
 */
public class GenerateRandomPointInACircleSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private final Random random;
    private final double radius;
    private final double x_center;
    private final double y_center;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
        random = new Random();
    }
    
    public double[] randPoint() {
        double x, y;
        do {
            x = random.nextDouble();
            y = random.nextDouble();
        } while ((x - 0.5) * (x - 0.5) + (y - 0.5) * (y - 0.5) > 0.25);
        return new double[]{x_center - radius + x * 2 * radius, y_center - radius + y * 2 * radius};
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
