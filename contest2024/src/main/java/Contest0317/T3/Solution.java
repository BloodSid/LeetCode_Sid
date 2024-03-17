package Contest0317.T3;

/**
 * @author IronSid
 * @since 2024-03-17 10:22
 */
public class Solution {
    public int minimumDeletions(String word, int k) {
        int[] f = new int[128];
        for (char c : word.toCharArray()) {
            f[c]++;
        }
        int res = word.length();
        // 枚举c作为频率最小的字符
        for (char c = 'a'; c <= 'z'; c++) {
            int sum = 0;
            if (f[c] == 0) {
                continue;
            }
            for (char d = 'a'; d <= 'z'; d++) {
                if (f[d] > f[c] + k) {
                    sum += f[d] - f[c] - k;
                }
                if (f[d] < f[c]) {
                    sum += f[d];
                }
            }
            res = Math.min(res, sum);
        }
        return res;
    }
}
