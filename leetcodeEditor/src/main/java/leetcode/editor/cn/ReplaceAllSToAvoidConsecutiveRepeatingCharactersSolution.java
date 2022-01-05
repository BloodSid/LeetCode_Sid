package leetcode.editor.cn;

import java.util.*;

/**
 * 替换所有的问号
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-05 18:05:58
 */
public class ReplaceAllSToAvoidConsecutiveRepeatingCharactersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                arr[i] = 'a';
                while ((i > 0 && arr[i] == arr[i - 1]) || (i < arr.length - 1 && arr[i] == arr[i + 1])) {
                    arr[i]++;
                }
            }
        }
        return new String(arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
