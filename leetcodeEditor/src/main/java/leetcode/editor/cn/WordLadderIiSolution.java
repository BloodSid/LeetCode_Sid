package leetcode.editor.cn;

import java.util.*;

/**
 * 单词接龙 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-16 00:06:46 
 */
public class WordLadderIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<String>> res;
    private int target;
    private String endWord;
    private HashSet<String> visited;
    private LinkedList<String> stack;
    private int n;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        n = beginWord.length();
        this.endWord = endWord;
        visited = new HashSet<>(wordList);
        int depth = 0;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        loop :
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String s = queue.poll();
                if (s.equals(endWord)) {
                    break loop;
                }
                for (int i = 0; i < n; i++) {
                    char cur = s.charAt(i);
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != cur) {
                            String next = s.substring(0, i) + c + s.substring(i + 1);
                            // 若删除成功，则说明该节点未被遍历，加入队中
                            if (visited.remove(next)) {
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
            depth++;
        }
        res = new ArrayList<>();
        stack = new LinkedList<>();
        target = depth;
        this.visited = new HashSet<>(wordList);
        dfs(beginWord, 0);
        return res;
    }

    void dfs(String cur, int depth) {
        stack.addLast(cur);
        visited.remove(cur);
        if (depth == target && cur.equals(endWord)) {
            res.add(new LinkedList<>(stack));
        } else {
            for (int i = 0; i < n; i++) {
                char ch = cur.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != ch) {
                        String next = cur.substring(0, i) + c + cur.substring(i + 1);
                        // next还未被访问
                        if (visited.contains(next)) {
                            dfs(next, depth + 1);
                        }
                    }
                }
            }
        }
        stack.removeLast();
        visited.add(cur);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}

