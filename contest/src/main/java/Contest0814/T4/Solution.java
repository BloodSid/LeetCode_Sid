package Contest0814.T4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-08-14 10:23
 */
public class Solution {
    static int[][] f = new int[10][10];
    static {
        for (int i = 1; i < 10; i++) {
            f[i][i] = i;
        }
        for (int i = 1; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                f[i][j] = j * f[i][j - 1];
            }
        }
    }

    public int countSpecialNumbers(int n) {
        if (n < 10) return n;
        int num = n;
        List<Integer> digits = new ArrayList<>();
        while (num != 0) {
            digits.add(num % 10);
            num /= 10;
        }
        int len = digits.size();
        int ans = 0;
        // 位数相同
        boolean[] vis = new boolean[10];
        for (int i = len - 1, p = 1; i >= 0; i--, p++) {
            int cur = digits.get(i), cnt = 0;
            for (int j = cur - 1; j >= 0; j--) {
                if (i == len - 1 && j == 0) continue;
                if (!vis[j]) cnt++;
            }
            int a = 10 - p, b = a - (len - p) + 1;
            ans += b <= a ? cnt * f[b][a] : cnt;
            if (vis[cur]) break;
            vis[cur] = true;
            if (i == 0) ans++;
        }
        // 位数更少
        for (int i = 1, t = 9; i < len; i++) {
            ans += t;
            t = t * (10 - i);
        }
        return ans;
    }
}
