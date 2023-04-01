package Contest0401.T3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-04-01 23:30
 */
public class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        if (n == k) return 0;
        int gcd = (int) gcd(n, k);
        long[] sum = new long[gcd];
        List<Integer>[] list = new List[gcd];
        for (int i = 0; i < gcd; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            sum[i % gcd] += arr[i];
            list[i % gcd].add(arr[i]);
        }
        // 都改成中位数
        int size = n / gcd;
        long res = 0;
        for (int i = 0; i < gcd; i++) {
            list[i].sort((o1, o2) -> o1 - o2);
            long median = list[i].get((size - 1) / 2);
            for (int v : list[i]) {
                res += Math.abs(median - v);
            }
        }
        return res;
    }

    long gcd(long a, long b) {
        // gcd(a,b) = gcd(b,a mod b)
        while (b != 0) {
            long t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
