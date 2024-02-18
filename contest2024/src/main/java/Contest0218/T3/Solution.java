package Contest0218.T3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IronSid
 * @since 2024-02-18 10:30
 */
public class Solution {

    public static final int[][] DIRS = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int mostFrequentPrime(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 在每个单元格，你可以按以下方式生成数字
                for (int[] d : DIRS) {
                    int t = 0;
                    for (int k = i, l = j; k >= 0 && k < m && l >= 0 && l < n; k += d[0], l += d[1]) {
                        t = t * 10 + mat[k][l];
                        f.merge(t, 1, Integer::sum);
                    }
                }
            }
        }
        int res = -1;
        int maxF = 0;
        for (Map.Entry<Integer, Integer> e : f.entrySet()) {
            Integer val = e.getKey();
            if (val <= 10) continue;
            Integer freq = e.getValue();
            if (freq >= maxF && isPrime(val)) {
                if (freq == maxF) {
                    res = Math.max(res, val);
                } else {
                    res = val;
                }
                maxF = freq;
            }
        }
        return res;
    }

    private boolean isPrime(int N) {
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
    }
}
