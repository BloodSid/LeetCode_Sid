package Contest1030.T3;

/**
 * @author IronSid
 * @since 2022-10-30 10:29
 */
public class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        char[] s = Long.toString(n).toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] -= '0';
        }
        boolean longer = false;
        int sum = 0;
        for (char c : s) {
            sum += c;
        }
        int j = s.length - 1;
        while (sum > target) {
            s[j] = 0;
            if (j > 0) s[j - 1]++;
            else longer = true;
            for (int k = j - 1; k >= 0; k--) {
                if (s[k] != 10) break;
                s[k] = 0;
                if (k > 0) s[k - 1]++;
                else longer = true;
            }
            sum = longer ? 1 : 0;
            for (char c : s) {
                sum += c;
            }
            j--;
        }
        StringBuilder sb = new StringBuilder();
        if (longer) sb.append(1);
        for (int p = 0; p < s.length; p++) {
            sb.append((int) s[p]);
        }
        return Long.parseLong(sb.toString()) - n;
    }
}
