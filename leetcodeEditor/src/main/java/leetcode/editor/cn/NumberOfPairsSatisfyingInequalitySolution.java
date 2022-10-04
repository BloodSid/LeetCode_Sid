package leetcode.editor.cn;
//给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两个数组的大小都为 n ，同时给你一个整数 diff ，统计满足以下条件的 数对 (i, 
//j) ： 
//
// 
// 0 <= i < j <= n - 1 且 
// nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff. 
// 
//
// 请你返回满足条件的 数对数目 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [3,2,5], nums2 = [2,2,1], diff = 1
//输出：3
//解释：
//总共有 3 个满足条件的数对：
//1. i = 0, j = 1：3 - 2 <= 2 - 2 + 1 。因为 i < j 且 1 <= 1 ，这个数对满足条件。
//2. i = 0, j = 2：3 - 5 <= 2 - 1 + 1 。因为 i < j 且 -2 <= 2 ，这个数对满足条件。
//3. i = 1, j = 2：2 - 5 <= 2 - 1 + 1 。因为 i < j 且 -3 <= 2 ，这个数对满足条件。
//所以，我们返回 3 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,-1], nums2 = [-2,2], diff = -1
//输出：0
//解释：
//没有满足条件的任何数对，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 2 <= n <= 10⁵ 
// -10⁴ <= nums1[i], nums2[i] <= 10⁴ 
// -10⁴ <= diff <= 10⁴ 
// 
// 👍 6 👎 0


import java.util.*;

/**
 * 满足不等式的数对数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-04 19:37:49 
 */
public class NumberOfPairsSatisfyingInequalitySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }
        BIT bit = new BIT(n + 1);
        // 离散化，以供树状数组使用
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += bit.query(lowerBound(sorted, nums[i] + diff + 1));
            bit.add(lowerBound(sorted, nums[i]) + 1);
        }
        return res;
    }

    int lowerBound(int[] a, int x) {
        // 初始化区间为 r = n, 否则当所有元素都比 x 小时，无法正确地返回 n
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + r >> 1;
            if (a[mid] < x) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}

// 树状数组
class BIT {
    private final int[] tree;

    public BIT(int n) {
        tree = new int[n];
    }

    // arr[x] 加一
    public void add(int x) {
        while (x < tree.length) {
            tree[x]++;
            x += x & -x;
        }
    }

    // 返回 arr[0:x) 之和
    public int query(int x) {
        int res = 0;
        while (x > 0) {
            res += tree[x];
            x &= x - 1;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
