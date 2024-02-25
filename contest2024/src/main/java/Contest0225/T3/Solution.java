package Contest0225.T3;

/**
 * @author IronSid
 * @since 2024-02-25 10:31
 */
public class Solution {
    private int[] nums;
    private int[] changeIndices;
    private int n;

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        this.nums = nums;
        this.changeIndices = changeIndices;
        n = nums.length;
        int m = changeIndices.length;
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l != m ? l + 1 : -1;
    }

    // 判断t秒能不能标记全部下标
    boolean check(int t) {
        boolean[] mark = new boolean[n];
        long sum = 0;
        // 从后往前扫，尽量在最后一次标记
        for (int j = t; j >= 0; j--) {
            // 贪心：在最迟的一次进行标记
            int i = changeIndices[j] - 1;
            if (!mark[i]) {
                mark[i] = true;
                sum += nums[i];
            } else if (sum != 0) {
                // 不进行标记且还有待做的减一操作，则进行减一操作
                sum--;
            }
        }
        for (int i = 0; i < n; i++) {
            // 有未标记的元素
            if (!mark[i]) {
                return false;
            }
        }
        // 若sum大于零说明减一操作不足，不能全部标记
        return sum <= 0;
    }
}
