package leetcode.editor.cn;

import java.util.*;

/**
 * 二进制中1的个数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-16 09:50:25
 */
public class ErJinZhiZhong1deGeShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
