package Contest0430.T4;

/**
 * @author IronSid
 * @since 2023-04-30 10:34
 */
public class Solution {
    public String smallestBeautifulString(String s, int k) {
        char limit = (char) ('a' + k - 1);
        int n = s.length();
        char[] c = s.toCharArray();
        // 从最后一个字母开始
        int i = n - 1;
        c[i]++;
        while (i >= 0 && i < n) {
            if (c[i] > limit){
                // 找不到下一个字典序更大的
                if (i == 0) return "";
                c[i] = 'a';
                i--;
                c[i] += 1;
            } else if ((i >= 1 && c[i - 1] == c[i]) || (i >= 2 && c[i - 2] == c[i])) {
                // 构成了回文
                c[i]++;
            } else  {
                // k的限制和不是回文的限制都满足，检查之后的字符串
                i++;
            }

        }
        return new String(c);
    }
}
