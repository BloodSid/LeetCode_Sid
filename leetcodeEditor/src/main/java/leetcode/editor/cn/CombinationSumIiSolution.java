package leetcode.editor.cn;
//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// 👍 1016 👎 0


import java.util.*;

/**
 * 组合总和 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 19:46:27
 */
public class CombinationSumIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int N = 50 + 1;
    private List list;
    private int[] f;
    private Deque<Integer> stack;
    private int sum;
    private int target;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        this.target = target;
        list = new ArrayList();
        f = new int[N];
        stack = new LinkedList<>();
        for (int num : nums) {
            f[num]++;
        }
        sum = 0;
        dfs(1);
        return list;
    }

    void dfs(int i) {
        if (i == N) {
            if (sum == target) list.add(((LinkedList<Integer>) stack).clone());
            return;
        }
        dfs(i + 1);
        int cnt = Math.min(f[i], (target - sum) / i);
        for (int j = 0; j < cnt; j++) {
            stack.push(i);
            sum += i;
            dfs(i + 1);
        }
        sum -= cnt * i;
        for (int j = 0; j < cnt; j++) stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
