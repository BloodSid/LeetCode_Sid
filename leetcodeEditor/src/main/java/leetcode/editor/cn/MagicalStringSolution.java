package leetcode.editor.cn;
//神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则： 
//
// 
// 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。 
// 
//
// s 的前几个元素是 s = "1221121221221121122……" 。如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 
//2 1 22 1 22 11 2 11 22 ......" 。每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ...
//..." 。上面的出现次数正是 s 自身。 
//
// 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 6
//输出：3
//解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
// 👍 72 👎 0


/**
 * 神奇字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-31 00:17:59 
 */
public class MagicalStringSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static final int N = (int) 1e5;
    static int[] cnt = new int[N + 10];
    static {
        int[] s = new int[N + 10];
        s[0] = 1;
        s[1] = 2;
        s[2] = 2;
        for (int i = 2, j = 3, t = 2; j < N; i++) {
            t ^= 3;
            for (int k = 0; k < s[i]; k++, j++) {
                s[j] = t;
            }
        }
        for (int i = 0, t = 0; i < N; i++) {
            if (s[i] == 1) t++;
            cnt[i + 1] = t;
        }
    }
    public int magicalString(int n) {
        return cnt[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
