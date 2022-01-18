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
        int[] post = new int[a.length];
        post[a.length - 1] = 1;
        for (int i = post.length - 2; i >= 0; i--) {
            post[i] = a[i + 1] * post[i + 1];
        }
        int[] res = new int[a.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = post[i] * pre[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
