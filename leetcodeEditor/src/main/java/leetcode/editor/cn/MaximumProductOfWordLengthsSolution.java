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
        int[][] cnt = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int i1 = 0; i1 < words[i].length(); i1++) {
                cnt[i][words[i].charAt(i1) - 'a']++;
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                for (; k < 26; k++) {
                    if (cnt[i][k] != 0 && cnt[j][k] != 0) {
                        break;
                    }
                }
                if (k == 26) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
