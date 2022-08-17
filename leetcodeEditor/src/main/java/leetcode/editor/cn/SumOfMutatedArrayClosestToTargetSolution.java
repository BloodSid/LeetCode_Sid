package leetcode.editor.cn;
//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和
//最接近 target （最接近表示两者之差的绝对值最小）。 
//
// 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。 
//
// 请注意，答案不一定是 arr 中的数字。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,9,3], target = 10
//输出：3
//解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
// 
//
// 示例 2： 
//
// 输入：arr = [2,3,5], target = 10
//输出：5
// 
//
// 示例 3： 
//
// 输入：arr = [60864,25176,27249,21296,20204], target = 56803
//输出：11361
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 1 <= arr[i], target <= 10^5 
// 
// 👍 175 👎 0


/**
 * 转变数组后最接近目标值的数组和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-17 23:26:53 
 */
public class SumOfMutatedArrayClosestToTargetSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] arr;

    public int findBestValue(int[] arr, int target) {
        this.arr = arr;
        // 三分搜索
        int l = 0, r = (int) 1e5;
        while (l + 2 < r) {
            int lm = (2 * l + r) / 3;
            int rm = (2 * r + l) / 3;
            if (Math.abs(target - calc(lm)) <= Math.abs(target - calc(rm))) {
                // rm 对应的距离更大，则排除 [rm, r]
                r = rm;
            } else {
                // 反之排除 [l, lm]
                l = lm;
            }
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        // {l, l + 1, r} 这三个位置都有可能是最小值，找出最小值
        for (; l <= r; l++) {
            int diff = Math.abs(target - calc(l));
            if (diff < min) {
                min = diff;
                res = l;
            }
        }
        return res;
    }

    // 计算把比 val 大的数字都转换成 val 后的数组和
    int calc(int val) {
        int sum = 0;
        for (int a : arr) sum += Math.min(a, val);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
