package Contest0218.T4;

/**
 * @author IronSid
 * @since 2024-02-18 10:30
 */
public class Solution {

    public static final int M = 31;
    private Trie rt1;
    private Trie rt2;

    public long countPrefixSuffixPairs(String[] words) {
        rt1 = new Trie();
        rt2 = new Trie();
        long res = 0;
        // 从短串开始，计算并添加
        for (String w : words) {
            res += addAndCount(w);
        }
        return res;
    }

    private long addAndCount(String w) {
        long res = 0;
        Trie pre = rt1, suf = rt2;
        int n = w.length();
        for (int i = 0; i < n; i++) {
            char a = w.charAt(i), b = w.charAt(n - 1 - i);
            // 不存在则新建
            if (pre.children[a & M] == null) {
                pre.children[a & M] = new Trie();
            }
            if (suf.children[b & M] == null) {
                suf.children[b & M] = new Trie();
            }
            // 移动
            pre = pre.children[a & M];
            suf = suf.children[b & M];
            // 前后缀word同时存在且相同，累加
            if (pre.word != null && suf.word == pre.word) {
                res += pre.cnt;
            }
        }
        if (pre.word == null) {
            pre.word = w;
            suf.word = w;
        }
        pre.cnt++;
        suf.cnt++;
        return res;
    }

    class Trie {
        String word;
        Trie[] children = new Trie[27];
        int cnt = 0;
    }
}

