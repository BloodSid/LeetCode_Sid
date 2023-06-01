package leetcode.editor.cn;
//给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。 
//
// 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。 
//
// 返回礼盒的 最大 甜蜜度。 
//
// 
//
// 示例 1： 
//
// 
//输入：price = [13,5,1,8,21,2], k = 3
//输出：8
//解释：选出价格分别为 [13,5,21] 的三类糖果。
//礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
//可以证明能够取得的最大甜蜜度就是 8 。
// 
//
// 示例 2： 
//
// 
//输入：price = [1,3,1], k = 2
//输出：2
//解释：选出价格分别为 [1,3] 的两类糖果。 
//礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
//可以证明能够取得的最大甜蜜度就是 2 。
// 
//
// 示例 3： 
//
// 
//输入：price = [7,7,7,7], k = 2
//输出：0
//解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= price.length <= 10⁵ 
// 1 <= price[i] <= 10⁹ 
// 2 <= k <= price.length 
// 
//
// 👍 115 👎 0


import java.util.*;

/**
 * 礼盒的最大甜蜜度
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-06-01 21:02:40 
 */
public class MaximumTastinessOfCandyBasketSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int l = 0, r = price[n - 1] - price[0];
        while (l <= r) {
            int mid = l + r >> 1;
            if (maxBox(price, mid) >= k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    // 在递增数组a中计算相邻元素之差大于等于d的最长子序列
    private int maxBox(int[] a, int d) {
        // 贪心
        int cnt = 1;
        for (int i = 1, pre = a[0]; i < a.length; i++) {
            if (a[i] >= pre + d) {
                cnt++;
                pre = a[i];
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
