package leetcode.editor.cn;

import java.util.*;

/**
 * 连接词
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-28 15:36:48
 */
public class ConcatenatedWordsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        Trie trie = new Trie();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (trie.isConcatenated(word)) {
                result.add(word);
            } else {
                trie.add(word);
            }
        }
        return result;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    void add(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.word = s;
    }

    boolean isConcatenated(String s) {
        return isConcatenated(s.toCharArray(), 0);
    }

    boolean isConcatenated(char[] word, int start) {
        TrieNode cur = root;
        for (int i = start; i < word.length; i++) {
            cur = cur.children[word[i] - 'a'];
            if (cur == null) {
                return false;
            }
            if (cur.word != null && isConcatenated(word, i + 1)) {
                return true;
            }
        }
        return cur.word != null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
