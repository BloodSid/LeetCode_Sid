package leetcode.editor.cn;

/**
 * 水壶问题
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-14 16:18:39 
 */
public class WaterAndJugProblemSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // 设两个罐子的容积分别是 a, b, 目标容积是 m,
        // 排除等价状态后，每次操作只会让罐子里的总水量增加a，增加b，减少a，减少b
        // 那么当　ax + by = m　有解时，可以倒出目标体积
        // ax + by = m 若有解，则 m 是 gcd(a, b) 的倍数
        return targetCapacity <= jug1Capacity + jug2Capacity && targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;
    }

    int gcd(int a, int b) {
        // gcd(a,b) = gcd(b, a mod b)
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
