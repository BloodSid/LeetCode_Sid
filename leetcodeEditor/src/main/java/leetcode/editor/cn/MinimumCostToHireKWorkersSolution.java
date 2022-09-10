package leetcode.editor.cn;
//有 n 名工人。 给定两个数组 quality 和 wage ，其中，quality[i] 表示第 i 名工人的工作质量，其最低期望工资为 wage[i] 
//。 
//
// 现在我们想雇佣 k 名工人组成一个工资组。在雇佣 一组 k 名工人时，我们必须按照下述规则向他们支付工资： 
//
// 
// 对工资组中的每名工人，应当按其工作质量与同组其他工人的工作质量的比例来支付工资。 
// 工资组中的每名工人至少应当得到他们的最低期望工资。 
// 
//
// 给定整数 k ，返回 组成满足上述条件的付费群体所需的最小金额 。在实际答案的 10⁻⁵ 以内的答案将被接受。。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入： quality = [10,20,5], wage = [70,50,30], k = 2
//输出： 105.00000
//解释： 我们向 0 号工人支付 70，向 2 号工人支付 35。 
//
// 示例 2： 
//
// 
//输入： quality = [3,1,10,10,1], wage = [4,8,2,2,7], k = 3
//输出： 30.66667
//解释： 我们向 0 号工人支付 4，向 2 号和 3 号分别支付 13.33333。 
//
// 
//
// 提示： 
//
// 
// n == quality.length == wage.length 
// 1 <= k <= n <= 10⁴ 
// 1 <= quality[i], wage[i] <= 10⁴ 
// 
// 👍 157 👎 0


import java.util.*;

/**
 * 雇佣 K 名工人的最低成本
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-11 02:40:21 
 */
public class MinimumCostToHireKWorkersSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // wage / quality 从小到大排序
        int n = quality.length;
        Integer[] keys = new Integer[n];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = i;
        }
        Arrays.sort(keys, (o1, o2) -> wage[o1] * quality[o2] - wage[o2] * quality[o1]);
        // quality 最大的在堆顶
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer o) -> quality[o]).reversed());
        int sum = 0;
        for (int i = 0; i < k; i++) {
            pq.offer(keys[i]);
            sum += quality[keys[i]];
        }
        double maxRate = (double) wage[keys[k - 1]] / quality[keys[k - 1]];
        // 对于每个 i, 都测试如果把它换进结果集合，结果会不会更小，若更小则贪心地更换
        for (int i = k; i < n; i++) {
            if ((double) wage[keys[i]] / quality[keys[i]] * (sum - quality[pq.peek()] + quality[keys[i]])
                    < maxRate * sum) {
                maxRate = (double) wage[keys[i]] / quality[keys[i]];
                sum += quality[keys[i]] - quality[pq.poll()];
                pq.offer(keys[i]);
            }
        }
        return maxRate * sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
