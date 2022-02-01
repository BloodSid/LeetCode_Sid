package leetcode.editor.cn;

import java.util.*;

/**
 * 反转单词前缀
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-02 00:18:30
 */
public class ReversePrefixOfWordSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reversePrefix(String word, char ch) {
        char[] arr = word.toCharArray();
        int idx = 0;
        for (; idx < arr.length; idx++) {
            if (ch == arr[idx]) {
                break;
            }
        }
        if (idx != arr.length) {
            for (int i = 0, j = idx; i < j; i++, j--) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return new String(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
