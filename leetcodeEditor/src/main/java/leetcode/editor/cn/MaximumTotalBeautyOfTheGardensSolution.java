package leetcode.editor.cn;

import java.util.*;

/**
 * 花园的最大总美丽值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-10 12:40:22
 */
public class MaximumTotalBeautyOfTheGardensSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        int n = flowers.length;

        // 找到第一个不小于target的flowers元素的下标start
        int start = 0;
        for (int l = 0, r = n - 1; l <= r; start = l) {
            int mid = l + r >> 1;
            if (flowers[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 若所有元素都不小于target则直接返回 full * n
        if (start == 0) return (long) full * n;

        // 前缀和
        long[] preSum = new long[n + 1];
        long temp = 0;
        for (int i = 0; i < n; i++) {
            temp += flowers[i];
            preSum[i + 1] = temp;
        }

        // 用后缀和的方式记录把尾部的数个flowers补充至target后newFlowers的剩余数量
        long[] remain = new long[n + 1];
        remain[n] = newFlowers;
        temp = newFlowers;
        for (int i = n - 1; i >= 0; i--) {
            temp -= Math.max(0, target - flowers[i]);
            remain[i] = temp;
        }

        long max = 0;
        // 从 start 向前，枚举不同的填满方式。数组是有序的，所以贪心地填满更大的flowers[i]
        // 数组被i分成两部分，[0, i-1]是不填满的部分，[i, n-1]是填满的部分
        for (int i = start; i >= 0; i--) {
            // 此时newFlowers的剩余数量是remain[i]，若剩余数量不够继续填满则终止枚举
            if (remain[i] < 0) break;
            // 外层二分
            // 对不填满的部分中花的最少数目进行二分，找到合法的最少数目的最大值
            int l = 0, r = target - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                // 内层二分
                // 对于当前数目 mid, 在不填满的部分flowers[0, i-1]上二分搜索第一个大于等于mid的flowers[l1]
                int l1 = 0, r1 = i - 1;
                while (l1 <= r1) {
                    int mid1 = l1 + r1 >> 1;
                    if (flowers[mid1] >= mid) {
                        r1 = mid1 - 1;
                    } else {
                        l1 = mid1 + 1;
                    }
                }
                // flowers[0, l1-1] 都小于mid, flowers[l1, i-1]都大于等于mid,
                // 所以至少使用cost个花就可以把flowers[0, l1-1]都填至mid, 这样flowers[0, i-1]上的最小值就是mid
                long cost = (long) l1 * mid - preSum[l1];

                // 判断当前最小数目mid对应的cost是否合法从而进行二分
                if (cost <= remain[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // 完善部分的分数
            long res = (long) (n - i) * full;
            // 不完善部分的分数，如果没有不完善部分，这部分分数为零。外层的二分结束后，r的值就是合法的最小数目的最大值
            if (i != 0) res += (long) r * partial;

            max = Math.max(max, res);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
