package Contest0918.T4;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-09-18 10:28
 */
public class Solution {

    private final Trie root = new Trie();

    class Trie {
        int cnt = 0;
        HashMap<Character, Trie> children = new HashMap<>();
    }

    void insert(String s) {
        Trie cur = root;
        for (char c : s.toCharArray()) {
            cur.children.putIfAbsent(c, new Trie());
            cur = cur.children.get(c);
            cur.cnt++;
        }
    }

    int query(String s) {
        Trie cur = root;
        int score = 0;
        for (char c : s.toCharArray()) {
            cur = cur.children.get(c);
            score += cur.cnt;
        }
        return score;
    }
    public int[] sumPrefixScores(String[] words) {
        for (String word : words) {
            insert(word);
        }
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            res[i] = query(words[i]);
        }
        return res;
    }
}
