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
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        HashSet<String> set = new HashSet<>(wordList);
        int depth = 1;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String s = queue.poll();
                if (s.equals(endWord)) {
                    return depth;
                }
                for (int i = 0; i < n; i++) {
                    char cur = s.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != cur) {
                            String next = s.substring(0, i) + c + s.substring(i + 1);
                            // 若删除成功，则说明该节点未被遍历，加入队中
                            if (set.remove(next)) {
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
            depth++;
        }
        return 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
