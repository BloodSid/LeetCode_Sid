package Contest0918.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-09-18 10:28
 */
public class Solution {
    static int N = 1000 * 1000, idx = 0;
    static int[][] tr = new int[N][26];
    static int[] cnt = new int[N];

    void insert(String s) {
        int p = 0;
        for (char c : s.toCharArray()) {
            int u = c - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
            cnt[p]++;
        }
    }

    int query(String s) {
        int p = 0;
        int score = 0;
        for (char c : s.toCharArray()) {
            int u = c - 'a';
            p = tr[p][u];
            score += cnt[p];
        }
        return score;
    }
    public int[] sumPrefixScores(String[] words) {
        for (int i = 0; i <= idx; i++) {
            Arrays.fill(tr[i], 0);
        }
        Arrays.fill(cnt, 0, idx + 1, 0);
        idx = 0;
        for (String word : words) insert(word);
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) res[i] = query(words[i]);
        return res;
    }
}
