package leetcode.editor.cn;

/**
 * 找出数组的最大公约数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-21 16:58:41
 */
public class FindGreatestCommonDivisorOfArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return gcd(min, max);
    }

    int gcd(int a, int b) {
        // gcd(a,b)=gcd(b,a mod b)
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
