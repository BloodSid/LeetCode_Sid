package Contest1009.T1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author IronSid
 * @since 2022-10-09 10:27
 */
public class Solution {
    public int hardestWorker(int n, int[][] logs) {
        for (int i = logs.length - 1; i >= 1; i--) {
            logs[i][1] -= logs[i - 1][1];
        }
        Arrays.sort(logs, Comparator.comparingInt((int[] log) -> -log[1]).thenComparing(log -> log[0]));
        return logs[0][0];
    }
}
