package Contest1007.T4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-10-07 15:07
 */
public class Solution {

    public static final int INF = Integer.MAX_VALUE;
    private static final char[] s = "cdeeeehllloot".toCharArray();
    private static final char[] keys = "cdehlot".toCharArray();
    static HashMap<String, Integer> map = new HashMap<>();

    static int minCost(String word, String cards) {
        if (cards.length() == 0) return 0;
        String key = word + ":" + cards;
        Integer val = map.get(key);
        if (val != null) return val;
        int n = word.length();
        int min = INF;
        for (int i = 0; i < n; i++) {
            int j = cards.indexOf(word.charAt(i));
            if (j != -1) {
                int subCost = minCost(word.substring(0, i) + word.substring(i + 1),
                        cards.substring(0, j) + cards.substring(j + 1));
                min = Math.min(min, i * (n - i - 1) + subCost);
            }
        }
        map.put(key, min);
        return min;
    }

    private int[][] dp;
    private int[][] wordF;
    private String[] words;

    public int Leetcode(String[] words) {
        this.words = words;
        int n = words.length;
        wordF = new int[n][];
        for (int i = 0; i < wordF.length; i++) {
            wordF[i] = new int[128];
            for (char c : words[i].toCharArray()) {
                wordF[i][c]++;
            }
        }
        dp = new int[1 << s.length][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int res = f((1 << s.length) - 1, n - 1);
        return res == INF ? -1 : res;
    }

    int f(int mask, int idx) {
        if (mask == 0) return 0;
        if (idx < 0) return INF;
        if (dp[mask][idx] != -1) return dp[mask][idx];
        int[] freq = new int[128];
        for (int i = 0; i < s.length; i++) {
            // 根据状态统计当前已经有的字母
            if ((mask >> i & 1) != 0) freq[s[i]]++;
        }
        // 把当前已经有的字母和当前单词的字母取交集
        for (char key : keys) {
            freq[key] = Math.min(freq[key], wordF[idx][key]);
        }
        // 遍历该交集的每一种子集（包括空集和它本身）
        dp[mask][idx] = dfs(mask, idx, freq, 0, new StringBuilder());
        return dp[mask][idx];
    }

    // 返回最小的 cost
    int dfs(int mask, int idx, int[] freq, int kIdx, StringBuilder sb) {
        if (kIdx == keys.length) {
            int f = f(mask, idx - 1);
            return f == INF ? INF : f + minCost(words[idx], sb.toString());
        }
        char c = keys[kIdx];
        int min = dfs(mask, idx, freq, kIdx + 1, sb);
        // 找到未取的 c 在 s 中第一次出现的位置
        int j = 0;
        for (; j < s.length; j++) {
            if ((mask >> j & 1) == 1 && s[j] == c) break;
        }
        for (int i = 0; i < freq[c]; i++, j++) {
            // 计算新 mask 和分数
            sb.append(c);
            mask ^= 1 << j;
            min = Math.min(min, dfs(mask, idx, freq, kIdx + 1, sb));
        }
        sb.setLength(sb.length() - freq[c]);
        return min;
    }

}
