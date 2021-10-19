package leetcode.editor.cn;

import java.util.*;

/**
 * 添加与搜索单词 - 数据结构设计
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-19 23:28:43
 */
public class DesignAddAndSearchWordsDataStructureSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        int len = word.length();
        Deque<Trie> queue = new ArrayDeque<>();
        queue.offerLast(root);
        for (int i = 0; i < len && !queue.isEmpty(); i++) {
            char ch = word.charAt(i);
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Trie cur = queue.pollFirst();
                if (ch == '.') {
                    for (Character child : cur.children.keySet()) {
                        queue.offerLast(cur.children.get(child));
                    }
                } else {
                    if (cur.children.containsKey(ch)) {
                        queue.offerLast(cur.children.get(ch));
                    }
                }
            }
        }
        for (Trie trie : queue) {
            if (trie.isWord) {
                return true;
            }
        }
        return false;
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
//leetcode submit region end(Prohibit modification and deletion)

}
