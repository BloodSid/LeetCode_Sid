package leetcode.editor.cn;
//给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。 
//
// 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目： 
//
// 
// 0 <= i < j < n 
// nums[i] > nums[j] 
// 
//
// 局部倒置 的数目等于满足下述条件的下标 i 的数目： 
//
// 
// 0 <= i < n - 1 
// nums[i] > nums[i + 1] 
// 
//
// 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,2]
//输出：true
//解释：有 1 个全局倒置，和 1 个局部倒置。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,0]
//输出：false
//解释：有 2 个全局倒置，和 1 个局部倒置。
// 
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 0 <= nums[i] < n 
// nums 中的所有整数 互不相同 
// nums 是范围 [0, n - 1] 内所有数字组成的一个排列 
// 
// 👍 160 👎 0


/**
 * 全局倒置与局部倒置
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-16 17:32:48 
 */
public class GlobalAndLocalInversionsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] t;

    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int local = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) local++;
        }
        int global = 0;
        t = new int[n + 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (global > local) break;
            // 找当前元素之后更小的元素有几个
            global += query(nums[i]);
            add(nums[i] + 1);
        }
        return global == local;
    }

    void add(int x) {
        while (x < t.length) {
            t[x]++;
            x += x & -x;
        }
    }

    int query(int x) {
        int res = 0;
        while (x > 0) {
            res += t[x];
            x &= x - 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
