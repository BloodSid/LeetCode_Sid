package leetcode.editor.cn;
//给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。 
//
// 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j 
//< arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。 
//
// 如果无法让 arr1 严格递增，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
//输出：1
//解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
// 
//
// 示例 2： 
//
// 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
//输出：2
//解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
// 
//
// 示例 3： 
//
// 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
//输出：-1
//解释：无法使 arr1 严格递增。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 2000 
// 0 <= arr1[i], arr2[i] <= 10^9 
// 
//
// 
//
// 👍 159 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 使数组严格递增
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-20 18:49:19 
 */
public class MakeArrayStrictlyIncreasingSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int INF = (int) (1e9 + 7);
    private HashMap<Integer, Integer>[] dp;
    int[] a, b;

    public int makeArrayIncreasing(int[] a1, int[] a2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : a2) {
            set.add(i);
        }
        int[] b = new int[set.size()];
        int bi = 0;
        for (Integer v : set) {
            b[bi++] = v;
        }
        Arrays.sort(b);
        this.a = a1;
        this.b = b;
        int n = a1.length;
        dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = dp(n - 1, INF);
        return ans <= n ? ans : -1;
    }

    // dp(i, j) 表示 a1[0,i]变为严格递增，且最后一个元素小于 pre 的最小操作数
    int dp(int i, int pre) {
        if (i < 0) return 0;
        if (dp[i].containsKey(pre)) return dp[i].get(pre);
        int res = 0;
        // 不替换
        if (a[i] < pre) {
            res = dp(i - 1, a[i]);
        } else {
            res = INF;
        }
        // 替换，需要找到b中恰比pre小的数去替换
        int k = lowerBound(b, pre) - 1;
        if (k >= 0) {
            res = Math.min(res, dp(i - 1, b[k]) + 1);
        }
        dp[i].put(pre, res);
        return res;
    }

    int lowerBound(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (a[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
