package leetcode.editor.cn;

import java.util.*;

/**
 * 最大单词长度乘积
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-17 01:00:45
 */
public class MaximumProductOfWordLengthsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        // 用26bit表示词频
        HashMap<Integer, Integer> f = new HashMap<>();
        for (String word : words) {
            int bits = 0;
            for (char c : word.toCharArray()) {
                bits |= 1 << (c & 31);
            }
            // 记录词频对应的最大长度
            f.merge(bits, word.length(), Math::max);
        }
        int max = 0;
        Integer[] b = f.keySet().toArray(new Integer[0]);
        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b.length; j++) {
                if ((b[i] & b[j]) == 0) max = Math.max(max, f.get(b[i]) * f.get(b[j]));
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
