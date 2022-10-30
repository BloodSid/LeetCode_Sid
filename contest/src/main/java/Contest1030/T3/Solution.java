package Contest1030.T3;

/**
 * @author IronSid
 * @since 2022-10-30 10:29
 */
public class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        char[] cs = Long.toString(n).toCharArray();
        int[] s = new int[cs.length];
        for (int i = 0; i < s.length; i++) {
            s[i] = cs[i] - '0';
        }
        int sum = 0;
        for (int c : s) {
            sum += c;
        }
        if (sum <= target) return 0;
        int p = -1;
        int pre = 0;
        // [0,p] 不变，剩下的位置变零
        for (int i = 0; i < s.length; i++) {
            pre += s[i];
            if (pre + 1 <= target) {
                p = i;
            } else {
                break;
            }
        }
        if (p >= 0) s[p]++;
        for (int i = p + 1; i < s.length; i++) {
            s[i] = 0;
        }
        for (int i = p; i >= 0; i--) {
            if (s[i] == 10) {
                s[i] = 0;
                if (i == 0) p = -1;
                else s[i - 1]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (p == -1) sb.append(1);
        for (int i = 0; i < s.length; i++) {
            sb.append(s[i]);
        }
        return Long.parseLong(sb.toString()) - n;
    }
}
