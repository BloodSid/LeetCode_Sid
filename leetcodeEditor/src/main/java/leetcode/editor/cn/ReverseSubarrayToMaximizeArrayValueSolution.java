package leetcode.editor.cn;
//给你一个整数数组 nums 。「数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。 
//
// 你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作 一次 。 
//
// 请你找到可行的最大 数组值 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,1,5,4]
//输出：10
//解释：通过翻转子数组 [3,1,5] ，数组变成 [2,5,1,3,4] ，数组值为 10 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,9,24,2,1,10]
//输出：68
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3*10^4 
// -10^5 <= nums[i] <= 10^5 
// 
//
// 👍 73 👎 0




/**
 * 翻转子数组得到最大的数组值
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-11 23:57:10 
 */
public class ReverseSubarrayToMaximizeArrayValueSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValueAfterReverse(int[] c) {
        // 基本情况，不反转或者反转数组长度为1
        long base = 0;
        int n = c.length;
        // 设被反转的子数组左右边界上的4个数分别是a,b,x,y 反转后数组值的变化 d = abs(a-x) + abs(b-y) - abs(a-b) - abs(x-y)
        // 分类讨论，不妨设a<=b：
        // 若a,b <= x,y 则 d = x-a+y-b-|a-b|-|x-y| = x+y-|x-y|-a-b-|a-b| = 2min(x,y)-2max(a,b) >= 0
        // 若a,x <= b,y 则 d = 2max(a,x) - 2min(b,y) <= 0 对结果无影响，可以不考虑
        // 若a,y <= b,x 则 d = 0 同上
        long d = 0;
        // 相邻元素a,b，分别维护 min(a,b) 的最大值mx，max(a,b)的最小值mn
        long mx = Long.MIN_VALUE, mn = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            base += Math.abs(c[i] - c[i + 1]);
            mx = Math.max(mx, Math.min(c[i], c[i + 1]));
            mn = Math.min(mn, Math.max(c[i], c[i + 1]));
            // 特别地，计算子数组的左边或者右边没有数的情况
            d = Math.max(d, Math.abs(c[0] - c[i + 1]) - Math.abs(c[i] - c[i + 1]));
            d = Math.max(d, Math.abs(c[n - 1] - c[i]) - Math.abs(c[i] - c[i + 1]));
        }
        d = Math.max(d, 2 * (mx - mn));
        return (int) (base + d);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
