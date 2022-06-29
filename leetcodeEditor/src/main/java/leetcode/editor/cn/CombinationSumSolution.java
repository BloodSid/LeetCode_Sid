package leetcode.editor.cn;
//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
// 👍 2031 👎 0


import java.util.*;

/**
 * 组合总和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 19:46:15
 */
public class CombinationSumSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List list;
    private Deque<Integer> stack;
    int sum;
    private int[] candidates;
    private int target;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        list = new ArrayList();
        stack = new LinkedList<>();
        sum = 0;
        dfs(candidates.length - 1);
        return list;
    }

    void dfs(int i) {
        if (i == -1) {
            if (sum == target) list.add(new LinkedList<>(stack));
            return;
        }
        dfs(i - 1);
        int e = candidates[i];
        int cnt = (target - sum) / e;
        for (int j = 0; j < cnt; j++) {
            stack.push(e);
            sum += e;
            dfs(i - 1);
        }
        sum -= cnt * e;
        for (int j = 0; j < cnt; j++) stack.pop();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
