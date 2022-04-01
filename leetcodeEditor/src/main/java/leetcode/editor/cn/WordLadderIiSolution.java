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
    // 记录每个单词到起点单词的最短路长度
    private Map<String, Integer> d;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        n = beginWord.length();
        d = new HashMap<>();
        this.endWord = endWord;
        visited = new HashSet<>(wordList);
        int depth = 0;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.remove(beginWord);
        boolean exist = false;
        loop :
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String s = queue.poll();
                d.put(s, depth);
                if (s.equals(endWord)) {
                    exist = true;
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
        if (!exist) return res;
        stack = new LinkedList<>();
        target = depth + 1;
        dfs(beginWord);
        return res;
    }

    void dfs(String cur) {
        stack.addLast(cur);
        // 只要达到目标深度就一定停止搜索
        if (stack.size() == target) {
            // 若找到目标单词则把当前栈中序列加入结果，若不是目标单词也不继续搜索
            if (cur.equals(endWord)) {
                res.add(new LinkedList<>(stack));
            }
        } else {
            for (int i = 0; i < n; i++) {
                char ch = cur.charAt(i);
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != ch) {
                        String next = cur.substring(0, i) + c + cur.substring(i + 1);
                        if (d.getOrDefault(next, 0) == stack.size()) {
                            dfs(next);
                        }
                    }
                }
            }
        }
        stack.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}

