package Contest1112.T4;

/**
 * @author IronSid
 * @since 2022-11-12 21:44
 */
public class Solution {
    public String[] splitMessage(String message, int limit) {
        if (limit <= 5) return new String[0];
        char[] ch = message.toCharArray();
        int n = ch.length;
        // 对位数为 1，2，3，4，5 的 b 分组考虑
        for (int len = 1, low = 1; len <= 5; len++, low *= 10) {
            if (low > n) break;
            if (3 + len * 2 > limit) break;
            // 对分成的部分的数量进行二分
            int l = low, r = 10 * low - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                //  sum 数字部分的总长
                int sum = mid * Integer.toString(mid).length();
                // 1 到 mid 的总长
                for (int i = 1, j = 1; i <= n; i *= 10, j++) {
                    sum += j * (Math.min(n + 1, 10 * i) - i);
                }
                boolean flag = n + mid * 3 + sum <= mid * limit;
                if (flag) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            // 找到最小分法
            if (l != 10 * low) {
                String[] res = new String[l];
                for (int i = 0, p = 0; i < l; i++) {
                    String s = "<" + (i + 1) + "/" + l + ">";
                    res[i] = new String(ch, p, Math.min(n - p, limit - s.length())) + s;
                    p += limit - s.length();
                }
                return res;
            }
        }
        return new String[0];
    }
}
