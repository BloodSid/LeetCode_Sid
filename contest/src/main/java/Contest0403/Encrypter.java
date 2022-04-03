package Contest0403;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-04-03 11:17
 */
// T4
public class Encrypter {

    private final Trie root;
    private final String[] kToV;
    private final Map<String, List<Character>> vToK;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        root = new Trie();
        for (String s : dictionary) {
            root.insert(s);
        }
        int n = keys.length;
        kToV = new String[26];
        for (int i = 0; i < n; i++) {
            kToV[keys[i] - 'a'] = values[i];
        }
        vToK = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!vToK.containsKey(values[i])) {
                vToK.put(values[i], new ArrayList<>());
            }
            vToK.get(values[i]).add(keys[i]);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            sb.append(kToV[ch - 'a']);
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        int n = word2.length() / 2;
        List<Character>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = vToK.get(word2.substring(i * 2, i * 2 + 2));
        }
        return dfs(root, 0, lists);
    }

    int dfs(Trie node, int depth, List<Character>[] lists) {
        if (node == null) {
            return 0;
        }
        if (depth == lists.length) {
            return node.isWord ? 1 : 0;
        }
        int cnt = 0;
        List<Character> list = lists[depth];
        if (list == null) return 0;
        for (Character ch : list) {
            cnt += dfs(node.children.get(ch), depth + 1, lists);
        }
        return cnt;
    }
}

class Trie {
    boolean isWord;
    String word;
    Map<Character, Trie> children;

    public Trie() {
        this.word = "";
        this.children = new HashMap<>();
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            cur.children.putIfAbsent(ch, new Trie());
            cur = cur.children.get(ch);
        }
        cur.word = word;
        cur.isWord = true;
    }
}
