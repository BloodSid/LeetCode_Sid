package leetcode.editor.cn;

import java.util.*;

/**
 * 从英文中重建数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-24 08:21:17
 */
public class ReconstructOriginalDigitsFromEnglishSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] freqs;

    public String originalDigits(String s) {
        String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        freqs = new int[10][26];
        for (int i = 0; i < digits.length; i++) {
            for (int j = 0; j < digits[i].length(); j++) {
                freqs[i][digits[i].charAt(j) - 'a']++;
            }
        }
        int[] sFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
        }
        int[] cnt = new int[10];
        dfs(0, cnt, sFreq);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            for (int i1 = 0; i1 < cnt[i]; i1++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    boolean dfs(int digit, int[] cnt, int[] sFreq) {
        if (digit == 10) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (freqs[digit][i] != 0) {
                min = Math.min(min, sFreq[i] / freqs[digit][i]);
            }
        }
        int[] tem = sFreq.clone();
        for (int i = 0; i <= min; i++) {
            cnt[digit] = i;
            for (int j = 0; j < 26; j++) {
                sFreq[j] = tem[j] - i * freqs[digit][j];
            }
            // 若所有字母剩余数量都是0，则返回true
            int k = 0;
            for (; k < 26; k++) {
                if (sFreq[k] != 0) {
                    break;
                }
            }
            if (k == 26) {
                return true;
            }
            // 递归运算剩下的数字
            if (dfs(digit + 1, cnt, sFreq)) {
                return true;
            }
        }
        // 回溯
        cnt[digit] = 0;
        System.arraycopy(tem, 0, sFreq, 0, sFreq.length);
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
