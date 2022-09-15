package leetcode.editor.cn;
//房间中有 n 只已经打开的灯泡，编号从 1 到 n 。墙上挂着 4 个开关 。 
//
// 这 4 个开关各自都具有不同的功能，其中： 
//
// 
// 开关 1 ：反转当前所有灯的状态（即开变为关，关变为开） 
// 开关 2 ：反转编号为偶数的灯的状态（即 2, 4, ...） 
// 开关 3 ：反转编号为奇数的灯的状态（即 1, 3, ...） 
// 开关 4 ：反转编号为 j = 3k + 1 的灯的状态，其中 k = 0, 1, 2, ...（即 1, 4, 7, 10, ...） 
// 
//
// 你必须 恰好 按压开关 presses 次。每次按压，你都需要从 4 个开关中选出一个来执行按压操作。 
//
// 给你两个整数 n 和 presses ，执行完所有按压之后，返回 不同可能状态 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1, presses = 1
//输出：2
//解释：状态可以是：
//- 按压开关 1 ，[关]
//- 按压开关 2 ，[开]
// 
//
// 示例 2： 
//
// 
//输入：n = 2, presses = 1
//输出：3
//解释：状态可以是：
//- 按压开关 1 ，[关, 关]
//- 按压开关 2 ，[开, 关]
//- 按压开关 3 ，[关, 开]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, presses = 1
//输出：4
//解释：状态可以是：
//- 按压开关 1 ，[关, 关, 关]
//- 按压开关 2 ，[关, 开, 关]
//- 按压开关 3 ，[开, 关, 开]
//- 按压开关 4 ，[关, 开, 开]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 0 <= presses <= 1000 
// 
// 👍 137 👎 0


import java.util.*;

/**
 * 灯泡开关 Ⅱ
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-15 10:18:24 
 */
public class BulbSwitcherIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashSet<Integer> set;
    private int n;

    public int flipLights(int n, int presses) {
        this.n = Math.min(n, 6);
        set = new HashSet<>();
        // 操作顺序不影响最终的结果，且一个开关操作两次等于没操作，所以只要枚举最终的开关状态即可
        if (presses > 4) {
            if (presses % 2 == 0) presses = 4;
            else presses = 3;
        }
        // 枚举开着的开关数
        for (int cnt = presses; cnt >= 0; cnt -= 2) {
            // 枚举开关状态
            boolean[] on = new boolean[4];
            dfs(0, cnt, on);
        }
        return set.size();
    }

    void dfs(int begin, int cnt, boolean[] on) {
        if (cnt == 0) {
            // 回溯终点
            int status = 0;
            // 开关1：全开
            if (on[0]) status = (1 << n) - 1;
            // 开关2：反转奇数位置（题中下标从1开始，而这里下标从0开始）
            if (on[1]) {
                for (int i = 1; i < n; i += 2) {
                    status ^= 1 << i;
                }
            }
            // 开关3：反转偶数位置
            if (on[2]) {
                for (int i = 0; i < n; i += 2) {
                    status ^= 1 << i;
                }
            }
            // 开关4：反转 3k 位置
            if (on[3]) {
                for (int i = 0; i < n; i += 3) {
                    status ^= 1 << i;
                }
            }
            set.add(status);
            return;
        }
        for (int cur = begin; cur < 4; cur++) {
            on[cur] = true;
            dfs(cur + 1, cnt - 1, on);
            on[cur] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
