package Contest0212.T4;

/**
 * @author IronSid
 * @since 2023-02-12 10:29
 */
public class Solution {
    public int minimumScore(String ss, String ts) {
        char[] s = ss.toCharArray();
        char[] t = ts.toCharArray();
        int min = t.length;
        // s 长度 i 的前缀对应的最长的 t 的前缀的结尾下标。对应指后者是前者的子序列
        int[] preM = new int[s.length + 1];
        for (int i = 0, j = 0; i < s.length; i++) {
            if (j < t.length && s[i] == t[j]) {
               j++;
           }
            preM[i + 1] = j;
        }
        // 枚举 s 的后缀找对应的最长的 t 的后缀
        for (int i = s.length - 1, j = t.length - 1; i >= 0; i--) {
            if (j >= 0 && s[i] == t[j]) {
                j--;
            }
            min = Math.min(min, j - preM[i] + 1);
        }
        min = Math.min(min, t.length - preM[s.length]);
        return Math.max(0, min);
    }
}
