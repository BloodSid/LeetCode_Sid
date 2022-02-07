package leetcode.editor.cn;


/**
 * 去掉最低工资和最高工资后的工资平均值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-08 00:27:35
 */
public class AverageSalaryExcludingTheMinimumAndMaximumSalarySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double average(int[] salary) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j : salary) {
            sum += j;
            max = Math.max(max, j);
            min = Math.min(min, j);
        }
        return (double) (sum - min - max) / (salary.length - 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
