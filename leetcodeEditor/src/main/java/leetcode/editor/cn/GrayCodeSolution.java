package leetcode.editor.cn;

import java.util.*;

/**
 * 格雷编码
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-08 23:21:25 
 */
public class GrayCodeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>(1 << n);
        for (int i = 0; i < 1 << n; i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
