package leetcode.editor.cn;
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// 👍 866 👎 0


import java.util.*;

/**
 * 子集 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 19:16:31 
 */
public class SubsetsIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int OFFSET = 10;
    public static final int N = 21;
    private List list;
    private int[] f;
    private Deque<Integer> stack;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list = new ArrayList();
        f = new int[N];
        stack = new LinkedList<>();
        for (int num : nums) {
            f[num + OFFSET]++;
        }
        dfs(0);
        return list;
    }

    void dfs(int i) {
        if (i == N) {
            list.add(new LinkedList<>(stack));
            return;
        }
        dfs(i + 1);
        int e = i - OFFSET;
        int cnt = f[i];
        for (int j = 0; j < cnt; j++) {
            stack.push(e);
            dfs(i + 1);
        }
        for (int j = 0; j < cnt; j++) stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}