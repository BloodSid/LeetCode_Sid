package leetcode.editor.cn;

import java.util.*;

/**
 * 左旋转字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-29 20:28:41 
 */
public class ZuoXuanZhuanZiFuChuanLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] res = new char[len];
        for (int i = 0; i < len; i++) {
            res[i] = s.charAt((i + n) % len);
        }
        return new String(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
