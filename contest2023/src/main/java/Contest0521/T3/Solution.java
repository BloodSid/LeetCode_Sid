package Contest0521.T3;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2023-05-21 10:21
 */
public class Solution {
    static int[] p = new int[1001];
    static {
        for (int i = 1; i <= 1000; i++) {
            boolean flag = canSplit(i);
            p[i] = (flag ? i * i : 0) + p[i - 1];
        }
    }
    public int punishmentNumber(int n) {
        return p[n];
    }

    static boolean canSplit(int i) {
        String s = String.valueOf(i * i);
        int n = s.length();
        HashSet<Integer>[] sum = new HashSet[n + 1];
        for (int i1 = 0; i1 <= n; i1++) {
            sum[i1] = new HashSet<>();
        }
        sum[0].add(0);
        for (int end = 1; end <= n; end++) {
            for (int start = end - 1; start >= 0; start--) {
                int cur = Integer.parseInt(s.substring(start, end));
                if (cur > i) break;
                for (Integer pre : sum[start]) {
                    int t = cur + pre;
                    if (t > i) continue;
                    sum[end].add(t);
                }
            }
        }
        return sum[n].contains(i);
    }
}