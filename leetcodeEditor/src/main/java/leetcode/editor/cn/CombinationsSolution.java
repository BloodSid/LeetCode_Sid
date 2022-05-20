package leetcode.editor.cn;

import java.util.*;

/**
 * 组合
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-20 22:22:11 
 */
public class CombinationsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int n;
    private int k;
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(1);
        return res;
    }

    void dfs(int num) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = num; i <= n; i++) {
            list.add(i);
            dfs(i + 1);
            list.remove(list.size() - 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
