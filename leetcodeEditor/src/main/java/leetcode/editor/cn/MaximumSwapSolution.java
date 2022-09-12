package leetcode.editor.cn;
//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
// 👍 265 👎 0


/**
 * 最大交换
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-13 00:13:09 
 */
public class MaximumSwapSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        char[] ch = Integer.toString(num).toCharArray();
        int i = 0, j = 0;
        for (i = 0; i < ch.length; i++) {
            char cur = ch[i];
            char max = 0;
            for (int k = i + 1; k < ch.length; k++) {
                if (ch[k] >= max) {
                    max = ch[k];
                    j = k;
                }
            }
            if (max > cur) break;
        }
        if (i == ch.length) return num;
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
        return Integer.parseInt(new String(ch));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
