package Contest0212.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-02-12 10:29
 */
public class Solution {
    public int minimumScore(String s, String t) {
        int[] map = new int[t.length()];
        Arrays.fill(map, -1);
        if (isSubsequent(s, t, map)) {
            return 0;
        }
        // 枚举是 s 的子序列的 t 的前缀，二分找到是 s 后半部分的子序列的 t 的后缀的最长长度，记录并找到两缀长度之和的最大值
        int max = 0;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = -1; i < map.length; i++) {
            if (i >= 0 && map[i] == -1) break;
            int sRight = i == -1 ? 0 : map[i] + 1;
            // t[:i+1] 对应 s[:map[i]+1]
            int l = 0, r = t.length() - i - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                // 判断 t 长度 mid 的后缀 t[n-mid:]是不是 s[map[i]+1:] 的子序列
                boolean flag = true;
                int j1 = sRight;
                for (int i1 = t.length() - mid; i1 < t.length(); i1++) {
                    char c = tc[i1];
                    for (; j1 < s.length(); j1++) {
                        if (sc[j1] == c) break;
                    }
                    if (j1 == s.length()) {
                        flag = false;
                        break;
                    }
                    j1++;
                }
                if (flag) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            // 最长可用长度是 r
            max = Math.max(max, r + i + 1);
        }
        return t.length() - max;
    }

    // map 记录 t 的前缀对应的 s 的前缀的下标
    boolean isSubsequent(String s, String sub, int[] map) {
        int j = 0;
        for (int i = 0; i < sub.length(); i++) {
            char c = sub.charAt(i);
            for (; j < s.length(); j++) {
                if (s.charAt(j) == c) break;
            }
            if (j == s.length()) return false;
            map[i] = j;
            j++;
        }
        return true;
    }
}
