package Contest0709.T3;

/**
 * @author IronSid
 * @since 2022-07-09 22:21
 */
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] d = new int[n];
        long sumD = 0;
        for (int i = 0; i < d.length; i++) {
            d[i] = Math.abs(nums1[i] -nums2[i]);
            sumD += d[i];
        }
        long k = k1 + k2;
        if (sumD <= k) return 0;
        int l = 0, r = (int) 1e5;
        while (l <= r) {
            int mid = l + r >> 1;
            long op = 0;
            for (int i = 0; i < n; i++) {
                op += d[i] <= mid ? 0 : d[i] - mid;
            }
            if (op <= k) r = mid - 1;
            else l = mid + 1;
        }
        // 把比 l 大的 d[i] 都要减到 l,
        long op = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] > l) {
                op += d[i] - l;
                d[i] = l;
            }
        }
        // 剩下的操作数要给大小为 l 的元素减1;
        op = k - op;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (op > 0 && d[i] == l) {
                d[i]--;
                op--;
            }
            res += (long) d[i] * d[i];
        }
        return res;
    }
}