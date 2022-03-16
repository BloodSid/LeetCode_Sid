package leetcode.editor.cn;

import java.util.*;

/**
 * 单词接龙
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-16 00:06:43 
 */
public class WordLadderSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashSet<String> set;
    private String endWord;
    private int n;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        n = beginWord.length();
        this.endWord = endWord;
        set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        int depth = dfs(beginWord);
        if (depth == Integer.MAX_VALUE) return 0;
        return depth;
    }

    int dfs(String s) {
        if (s.equals(endWord)) {
            return 1;
        }
        set.remove(s);
        int depth = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != cur) {
                    String next = s.substring(0, i) + c + s.substring(i + 1);
                    if (set.contains(next)) {
                        depth = Math.min(depth, dfs(next));
                    }
                }
            }
        }
        set.add(s);
        return depth == Integer.MAX_VALUE ? Integer.MAX_VALUE : depth + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
