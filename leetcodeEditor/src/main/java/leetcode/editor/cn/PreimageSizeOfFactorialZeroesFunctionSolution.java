package leetcode.editor.cn;
//f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。 
//
// 
// 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。 
// 
//
// 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 0
//输出：5
//解释：0!, 1!, 2!, 3!, 和 4! 均符合 k = 0 的条件。
// 
//
// 示例 2： 
//
// 
//输入：k = 5
//输出：0
//解释：没有匹配到这样的 x!，符合 k = 5 的条件。 
//
// 示例 3: 
//
// 
//输入: k = 3
//输出: 5
// 
//
// 
//
// 提示: 
//
// 
// 0 <= k <= 10⁹ 
// 
// 👍 97 👎 0


/**
 * 阶乘函数后 K 个零
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-28 00:12:37 
 */
public class PreimageSizeOfFactorialZeroesFunctionSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int preimageSizeFZF(int k) {
        // 二分搜索
        long l = 0, r = (long) 5e9;
        while (l <= r) {
            long mid = l + r >> 1;
            if (cnt(mid) < k) l = mid + 1;
            else r = mid - 1;
        }
        long start = l;
        l = start; r = (long) 5e9;
        while (l <= r) {
            long mid = l + r >> 1;
            if (cnt(mid) <= k) l = mid + 1;
            else  r = mid - 1;
        }
        long end = r;
        return (int) (end - start + 1);
    }

    // n! 阶乘后零的数量
    long cnt(long n) {
        long res = 0;
        while (n > 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
