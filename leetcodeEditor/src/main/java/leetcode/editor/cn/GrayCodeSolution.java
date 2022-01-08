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
        ans.add(0);
        for (int i = 0; i < n; i++) {
            int m = ans.size();
            for (int j = m - 1; j >= 0; j--) {
                ans.add(ans.get(j) + (1 << i));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
