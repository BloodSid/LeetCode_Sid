package leetcode.editor.cn;
//给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 20
//输出：1
//解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
// 
//
// 示例 2： 
//
// 
//输入：n = 100
//输出：10
//解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
// 
//
// 示例 3： 
//
// 
//输入：n = 1000
//输出：262
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
// 👍 109 👎 0


import java.util.ArrayList;
import java.util.List;

/**
 * 至少有 1 位重复的数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-14 12:27:05 
 */
public class NumbersWithRepeatedDigitsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDupDigitsAtMostN(int n) {
        // 计算有多少没有重复数字的数
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (int t = n; t > 0; t /= 10) {
            list.add(t % 10);
        }
        int len = list.size();
        // 记录对应数字是否在 n 中出现过
        boolean[] vis = new boolean[10];
        // 计算位数和 n 相等的有多少
        for (int i = len - 1, p = 1; i >= 0; i--, p++) {
            int cur = list.get(i);
            int cnt = 0;
            // 统计在 n 中 cur 的更高位上没有出现过，并且小于 cur 的数字
            for (int j = 0; j < cur; j++) {
                // 第一位不取零
                if (j == 0 && i == len - 1) continue;
                if (!vis[j]) cnt++;
            }
            // a 表示 cur 下一位上可以用的数，b 表示最后一位可以用的数
            int a = 10 - p, b = a - (len - p) + 1;
            // 计算在 cur 这一位上使用比 cur 更小的数字，可得到多少不重复的数
            for (int t = a; t >= b; t--) cnt *= t;
            ans += cnt;
            // 如果 cur 在高位上出现过，不再计算这一位上 cur 取 cur 的情况
            if (vis[cur]) break;
            // 如果 cur 在更高位上没出现过，则继续循环，计算这一位上取 cur 的情况
            vis[cur] = true;
            // 计算到最低位，最低位上取 cur 表示 n 自身
            if (i == 0) ans += 1;
        }
        // 计算位数比 n 少的有多少
        for (int i = 1, t = 9; i < len; i++) {
            ans += t;
            t *= 10 - i;
        }
        return n - ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
