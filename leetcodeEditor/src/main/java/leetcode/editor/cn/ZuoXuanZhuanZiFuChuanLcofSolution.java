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
        return (s + s).substring(n, n + s.length());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
