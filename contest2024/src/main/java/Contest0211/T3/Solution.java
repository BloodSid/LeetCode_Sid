package Contest0211.T3;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-02-11 10:03
 */
public class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        // 从短到长
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] f = new int[128];
        for (String s : words) {
            for (char c : s.toCharArray()) {
                f[c]++;
            }
        }
        int pair = 0, single = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            pair += f[c] / 2;
            single += f[c] % 2;
        }
        // 贪心：从较短的字符串开始，逐个填充
        int idx;
        for (idx = 0; idx < words.length; idx++) {
            int len = words[idx].length();
            // 成对的字母不足
            if (len / 2 > pair) {
                break;
            }
            pair -= len / 2;
            single -= len % 2;
            if (single < 0) {
                pair--;
                single += 2;
            }
        }
        return idx;
    }
}
