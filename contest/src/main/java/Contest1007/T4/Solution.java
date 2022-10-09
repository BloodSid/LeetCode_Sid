package Contest1007.T4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-10-07 15:07
 */
public class Solution {

    public static final int INF = Integer.MAX_VALUE;
    private final char[] s = "cdeeeehllloot".toCharArray();
    private final char[] keys = "cdehlot".toCharArray();
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
        List<String> subsets = permute(freq);
        // 遍历该交集的每一种子集（包括空集和它本身），计算新的 mask 和 取出该子集的分数
        int min = INF;
        for (String subset : subsets) {
            // 计算新 mask
            int newMask = mask;
            // s 的指针
            int p = 0;
            for (char c : subset.toCharArray()) {
                for (; p < s.length; p++) {
                    if ((mask >> p & 1) == 0) continue;
                    if (s[p] == c) {
                        newMask -= 1 << p;
                        p++;
                        break;
                    }
                }
            }
            int preF = f(newMask, idx - 1);
            if (preF == INF) continue;
            min = Math.min(min, preF + minCost(words[idx], subset));
        }
        // 取最小值
        dp[mask][idx] = min;
        return dp[mask][idx];
    }

    List<String> permute(int[] freq) {
        List<String> res = new ArrayList<>();
        dfs(freq, 0, res, new StringBuilder());
        return res;
    }

    void dfs(int[] freq, int kIdx, List<String> list, StringBuilder sb) {
        if (kIdx == keys.length) {
            list.add(sb.toString());
            return;
        }
        char c = keys[kIdx];
        int cnt = freq[c];
        dfs(freq, kIdx + 1, list, sb);
        for (int i = 0; i < cnt; i++) {
            sb.append(c);
            dfs(freq, kIdx + 1, list, sb);
        }
        sb.setLength(sb.length() - cnt);
    }

    HashMap<String, Integer> map = new HashMap<>();

    int minCost(String word, String cards) {
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

}
