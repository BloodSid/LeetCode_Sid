package leetcode.editor.cn;
//给定你一个整数数组 nums 
//
// 我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == 
//average(B) 。 
//
// 如果可以完成则返回true ， 否则返回 false 。 
//
// 注意：对于数组 arr , average(arr) 是 arr 的所有元素的和除以 arr 长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4,5,6,7,8]
//输出: true
//解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
// 
//
// 示例 2: 
//
// 
//输入: nums = [3,1]
//输出: false
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 30 
// 0 <= nums[i] <= 10⁴ 
// 
// 👍 238 👎 0


import java.util.*;

/**
 * 数组的均值分割
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-14 21:32:09 
 */
public class SplitArrayWithSameAverageSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int n;

    public boolean splitArraySameAverage(int[] nums) {
        n = nums.length;
        // 预处理：将所有的值都乘以 n, 以避免使用浮点型。再将所有的数都减 tot, 这样平均值就是 0
        int tot = 0;
        for (int i = 0; i < n; i++) {
            tot += nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - tot;
        }
        // 队列中存储 {sum, i}, 表示 i 个数字之和是 sum
        List<int[]> lq = new ArrayList<>();
        List<int[]> rq = new ArrayList<>();
        HashMap<Integer, Integer> ls = new HashMap<>();
        HashMap<Integer, Integer> rs = new HashMap<>();
        lq.add(new int[]{0, 0});
        rq.add(new int[]{0, 0});
        ls.put(0, 0);
        rs.put(0, 0);
        // 折半查找, 从两侧分别 bfs 分别找出元素和互为相反数的一对集合，它们的和就是 0，平均值就是 0
        int j = n / 2;
        for (int i = 0; i < n / 2; i++, j++) {
            if (bfs(nums[i], lq, ls, rs)) return true;
            if (bfs(nums[j], rq, rs, ls)) return true;
        }
        // 若数组长度是奇数，则右半边长一
        if (j == n - 1) return bfs(nums[j], rq, rs, ls);
        return false;
    }

    boolean bfs(int num, List<int[]> q, HashMap<Integer, Integer> cur, HashMap<Integer, Integer> other) {
        int size = q.size();
        // 每个节点有两个节点，分别表示加或者不加 num, 则原来就在队列中的 {sum, i}, 仍然要留在队列，并新加入 {sum + num, i + 1}
        for (int j = 0; j < size; j++) {
            int[] p = q.get(j);
            int sum = p[0] + num;
            int i = p[1] + 1;
            // 判断是否找到满足要求的结果：两侧存在一对集合，它们的元素和是 0, 它们的长度和小于 n
            if (other.containsKey(-sum) && other.get(-sum) + i < n) return true;
            // 根据是否已经存在和为 sum 的集合来决定是否入队
            if (!cur.containsKey(sum)) {
                q.add(new int[]{sum, i});
                cur.put(sum, i);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
