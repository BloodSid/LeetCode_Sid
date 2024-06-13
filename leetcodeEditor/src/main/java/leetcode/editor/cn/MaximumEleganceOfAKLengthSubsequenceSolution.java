package leetcode.editor.cn;
//给你一个长度为 n 的二维整数数组 items 和一个整数 k 。 
//
// items[i] = [profiti, categoryi]，其中 profiti 和 categoryi 分别表示第 i 个项目的利润和类别。 
//
// 现定义 items 的 子序列 的 优雅度 可以用 total_profit + distinct_categories² 计算，其中 total_
//profit 是子序列中所有项目的利润总和，distinct_categories 是所选子序列所含的所有类别中不同类别的数量。 
//
// 你的任务是从 items 所有长度为 k 的子序列中，找出 最大优雅度 。 
//
// 用整数形式表示并返回 items 中所有长度恰好为 k 的子序列的最大优雅度。 
//
// 注意：数组的子序列是经由原数组删除一些元素（可能不删除）而产生的新数组，且删除不改变其余元素相对顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：items = [[3,2],[5,1],[10,1]], k = 2
//输出：17
//解释：
//在这个例子中，我们需要选出长度为 2 的子序列。
//其中一种方案是 items[0] = [3,2] 和 items[2] = [10,1] 。
//子序列的总利润为 3 + 10 = 13 ，子序列包含 2 种不同类别 [2,1] 。
//因此，优雅度为 13 + 2² = 17 ，可以证明 17 是可以获得的最大优雅度。 
// 
//
// 示例 2： 
//
// 
//输入：items = [[3,1],[3,1],[2,2],[5,3]], k = 3
//输出：19
//解释：
//在这个例子中，我们需要选出长度为 3 的子序列。 
//其中一种方案是 items[0] = [3,1] ，items[2] = [2,2] 和 items[3] = [5,3] 。
//子序列的总利润为 3 + 2 + 5 = 10 ，子序列包含 3 种不同类别 [1, 2, 3] 。 
//因此，优雅度为 10 + 3² = 19 ，可以证明 19 是可以获得的最大优雅度。 
//
// 示例 3： 
//
// 
//输入：items = [[1,1],[2,1],[3,1]], k = 3
//输出：7
//解释：
//在这个例子中，我们需要选出长度为 3 的子序列。
//我们需要选中所有项目。
//子序列的总利润为 1 + 2 + 3 = 6，子序列包含 1 种不同类别 [1] 。
//因此，最大优雅度为 6 + 1² = 7 。 
//
// 
//
// 提示： 
//
// 
// 1 <= items.length == n <= 10⁵ 
// items[i].length == 2 
// items[i][0] == profiti 
// items[i][1] == categoryi 
// 1 <= profiti <= 10⁹ 
// 1 <= categoryi <= n 
// 1 <= k <= n 
// 
//
// 👍 35 👎 0


import java.util.*;

/**
 * 子序列最大优雅度
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-06-13 00:23:27 
 */
public class MaximumEleganceOfAKLengthSubsequenceSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        int n = items.length;
        // 按利润排序
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        // 记录已经选到的种类
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        // 选择利润最大的前k个，把同种类第二次以后的出现都记录在栈中
        Deque<int[]> duplicate = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            int[] item = items[i];
            sum += item[0];
            if (!set.add(item[1])) {
                duplicate.push(item);
            }
        }
        long category = set.size();
        long res = sum + category * category;
        // 反悔贪心，在种类必然增加的情况下换利润更小的
        for (int i = k; i < n; i++) {
            int[] cur = items[i];
            if (!duplicate.isEmpty() && set.add(cur[1])) {
                // 种类增加，用当前利润替换栈中最小利润
                sum += cur[0] - duplicate.pop()[0];
                category = set.size();
                res = Math.max(res, sum + category * category);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
