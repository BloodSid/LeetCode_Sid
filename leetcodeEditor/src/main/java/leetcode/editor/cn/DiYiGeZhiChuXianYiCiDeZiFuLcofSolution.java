package leetcode.editor.cn;

import java.util.*;

/**
 * 第一个只出现一次的字符
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-31 22:40:18
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        char ans = ' ';
        int index = Integer.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int head = s.indexOf(ch);
            if (head != -1 && head == s.lastIndexOf(ch)) {
                if (head < index) {
                    index = head;
                    ans = ch;
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
