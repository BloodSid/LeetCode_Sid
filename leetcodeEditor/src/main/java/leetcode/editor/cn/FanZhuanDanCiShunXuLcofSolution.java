package leetcode.editor.cn;

import java.util.*;

/**
 * 翻转单词顺序
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 00:19:20
 */
public class FanZhuanDanCiShunXuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split("\\s");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() == 0) {
                continue;
            }
            sb.append(arr[i]).append(' ');
        }
        int len = sb.length();
        if (len > 0) {
            sb.deleteCharAt(len - 1);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
