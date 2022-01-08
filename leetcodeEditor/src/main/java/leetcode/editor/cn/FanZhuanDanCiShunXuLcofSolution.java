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
        String[] arr = s.trim().split("\\s+");
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return String.join(" ", arr);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
