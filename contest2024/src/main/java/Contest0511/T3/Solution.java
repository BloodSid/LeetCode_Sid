package Contest0511.T3;

/**
 * @author IronSid
 * @since 2024-05-11 21:53
 */
public class Solution {

    private int[][] memo;
    private int[][] p;

    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        p = new int[n + 1][];
        p[0] = new int[26];
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[c[i] - 'a']++;
            p[i + 1] = cnt.clone();
        }
        memo = new int[n][n];
        return dp(0, n - 1);
    }

    int dp(int i, int j) {
        if (i == j || isBalanced(i, j)) {
            return 1;
        }
        if (memo[i][j] != 0) return memo[i][j];
        int res = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            res = Math.min(res, dp(i, k) + dp(k + 1, j));
        }
        return memo[i][j] = res;
    }

    private boolean isBalanced(int i, int j) {
        int h = 0;
        for (int t = 0; t < 26; t++) {
            int f = p[j + 1][t] - p[i][t];
            if (f == 0) continue;
            if (h == 0) {
                h = f;
            } else if (f != h) {
                return false;
            }
        }
        return true;
    }
}
