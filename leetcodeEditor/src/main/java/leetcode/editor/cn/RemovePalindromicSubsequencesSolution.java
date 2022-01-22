package leetcode.editor.cn;

import java.util.*;

/**
 * 删除回文子序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-22 20:46:53
 */
public class RemovePalindromicSubsequencesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removePalindromeSub(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                // 不是回文，可以先去掉所有的a，再去掉所有的b
                return 2;
            }
        }
        // 字符串是回文
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
