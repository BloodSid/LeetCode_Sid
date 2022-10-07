package Contest1007.T4;

import java.util.ArrayList;
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
    private HashMap<String, Integer> map = new HashMap<>();

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
        return f((1 << s.length) - 1, n - 1);
    }

    int f(int mask, int idx) {
        if (mask == 0) return 0;
        if (idx < 0) return INF;
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

    int minCost(String word, String cards) {
        String key = word + ":" + cards;
        Integer val = map.get(key);
        if (val != null) return val;
        int cost = 0;
        boolean[] vis = new boolean[cards.length()];
        for (int i = 0; i < cards.length(); i++) {
            int min = INF;
            int p1 = 0;
            int p2 = 0;
            for (int j = 0; j < cards.length(); j++) {
                if (vis[j]) continue;
                char card = cards.charAt(j);
                int left = word.indexOf(card);
                int right = word.lastIndexOf(card);
                if (left < min) {
                    min = left;
                    p1 = left;
                    p2 = j;
                }
                if (word.length() - 1 - right < min) {
                    min = word.length() - 1 - right;
                    p1 = right;
                    p2 = j;
                }
            }
            cost += p1 * (word.length() - p1 - 1);
            word = word.substring(0, p1) + word.substring(p1 + 1);
            vis[p2] = true;
        }
        map.put(key, cost);
        return cost;
    }

}
