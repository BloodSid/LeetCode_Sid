package leetcode.editor.cn;
//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件： 
//
// 
// 只使用数字1到9 
// 每个数字 最多使用一次 
// 
//
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。 
//
// 
//
// 示例 1: 
//
// 
//输入: k = 3, n = 7
//输出: [[1,2,4]]
//解释:
//1 + 2 + 4 = 7
//没有其他符合的组合了。 
//
// 示例 2: 
//
// 
//输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
//解释:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//没有其他符合的组合了。 
//
// 示例 3: 
//
// 
//输入: k = 4, n = 1
//输出: []
//解释: 不存在有效的组合。
//在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
// 
//
// 
//
// 提示: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
//
// 👍 821 👎 0


import java.util.*;

/**
 * 组合总和 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-04-21 09:16:09 
 */
public class CombinationSumIiiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        dfs(1, k, 0, n);
        return res;
    }

    private void dfs(int i, int k, int bits, int remain) {
        if (k == 0 && remain == 0) {
            List<Integer> list = new ArrayList<>();
            for (int t = 1; t <= 9; t++) {
                if ((bits >> t & 1) == 1) list.add(t);
            }
            res.add(list);
            return;
        }
        // 剪枝
        if ((9 + 9 - k + 1) * k / 2 < remain) { // 最大的取法也不够
            return;
        }
        if ((i + i + k - 1) * k / 2 > remain) { // 最小的取法也超出
            return;
        }
        // 不取
        dfs(i + 1, k, bits, remain);
        // 取
        dfs(i + 1, k - 1, bits | 1 << i, remain - i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
