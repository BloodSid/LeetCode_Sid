package leetcode.editor.cn;

import java.util.*;

/**
 * 构建乘积数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-18 11:52:10
 */
public class GouJianChengJiShuZuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] pre = new int[a.length];
        pre[0] = 1;
        for (int i = 1; i < pre.length; i++) {
            pre[i] = a[i - 1] * pre[i - 1];
        }
        int[] res = new int[a.length];
        int post = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = post * pre[i];
            post *= a[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
