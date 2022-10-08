package Contest0918.T4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-09-18 10:28
 */
public class Solution {
    static int N = 1000 * 1000, idx = 0;
    static int[][] tr = new int[N][26];
    static int[] cnt = new int[N];

    // 记录在该节点上终止的单词 id
    static List<Integer>[] ids = new List[N];
    private String[] words;
    private int[] res;

    void insert(int i) {
        int p = 0;
        for (char c : words[i].toCharArray()) {
            int u = c - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
            cnt[p]++;
        }
        if (ids[p] == null) ids[p] = new ArrayList<>();
        ids[p].add(i);
    }

    void dfs(int cur, int sum) {
        sum += cnt[cur];
        List<Integer> id = ids[cur];
        if (id != null) {
            for (Integer i : id) res[i] += sum;
        }
        for (int next : tr[cur]) {
            if (next != 0) dfs(next, sum);
        }
    }

    public int[] sumPrefixScores(String[] words) {
        this.words = words;
        for (int i = 0; i <= idx; i++) {
            Arrays.fill(tr[i], 0);
        }
        Arrays.fill(cnt, 0, idx + 1, 0);
        Arrays.fill(ids, 0, idx + 1, null);
        idx = 0;
        for (int i = 0; i < words.length; i++) insert(i);
        res = new int[words.length];
        dfs(0, 0);
        return res;
    }

}
