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
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (int t = n; t > 0; t /= 10) {
            list.add(t % 10);
        }
        int len = list.size();
        boolean[] vis = new boolean[10];
        for (int i = len - 1, p = 1; i >= 0; i--, p++) {
            int cur = list.get(i);
            int cnt = 0;
            for (int j = 0; j < cur; j++) {
                if (j == 0 && i == len - 1) continue;
                if (!vis[j]) cnt++;
            }
            int a = 10 - p, b = a - (len - p) + 1;
            for (int t = a; t >= b; t--) cnt *= t;
            ans += cnt;
            if (vis[cur]) break;
            vis[cur] = true;
            if (i == 0) ans += 1;
        }
        for (int i = 1, t = 9; i < len; i++) {
            ans += t;
            t *= 10 - i;
        }
        return n - ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
