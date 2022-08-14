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
        // 从最高位开始找
        for (int i = len - 1, p = 1; i >= 0; i--, p++) {
            int cur = digits.get(i), cnt = 0;
            for (int j = cur - 1; j >= 0; j--) {
                // 最高位不能取零
                if (i == len - 1 && j == 0) continue;
                // 不能取更高位用过的数
                if (!vis[j]) cnt++;
            }
            // 在剩下的 (10 - p) 个数中，取 (len - p) 个数进行排列
            int a = 10 - p, b = a - (len - p) + 1;
            // 若当前位不是最低位：用乘法原理算出方案数；若当前位是最低位则 cnt 为方案数
            ans += b <= a ? cnt * f[b][a] : cnt;
            // 遇到重复数值则终止
            if (vis[cur]) break;
            vis[cur] = true;
            // 到最低位时，最后方案数中要加上 n 自身
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
