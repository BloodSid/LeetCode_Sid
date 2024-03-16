package Contest0316.T3;

/**
 * @author IronSid
 * @since 2024-03-16 22:26
 */
public class Solution {
    public String minimizeStringValue(String s) {
        char[] ch = s.toCharArray();
        int[] f = new int[128];
        for (char c : ch) {
            f[c]++;
        }
        int[] of = f.clone();
        // 贪心，找到要填的字母的集合
        int n = ch.length;
        for (int i = 0; i < n; i++) {
            if (ch[i] != '?') continue;
            char res = 'a';
            for (char c = 'a'; c <= 'z'; c++) {
                if (f[c] < f[res]) {
                    res = c;
                }
            }
            f[res]++;
        }
        // 按字母从小到大在'?'位置填写
        int ci = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < f[c] - of[c] && ci < n; ci++) {
                if (ch[ci] == '?') {
                    i++;
                    ch[ci] = c;
                }
            }
        }
        return new String(ch);
    }
}
