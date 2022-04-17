package leetcode.editor.cn;

import java.util.*;

/**
 * 字典序排数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-18 00:43:39 
 */
public class LexicographicalNumbersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int n;
    private List<Integer> res;

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        res = new ArrayList<>(n);
        for (int i = 1; i <= Math.min(9, n); i++) {
            dfs(i);
        }
        return res;
    }

    void dfs(int num) {
        res.add(num);
        for (int i = num * 10; i <= Math.min(num * 10 + 9, n); i++) {
            dfs(i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
