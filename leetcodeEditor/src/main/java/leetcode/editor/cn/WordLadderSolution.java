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

    private int n;

    void add(HashMap<String, List<String>> map, String from, String to) {
        if (!map.containsKey(from)) {
            map.put(from, new ArrayList<>());
        }
        map.get(from).add(to);
    }

    void addEdges(String word, HashMap<String, List<String>> map) {
        char[] array = word.toCharArray();
        for (int i = 0; i < n; i++) {
            char ch = array[i];
            array[i] = '*';
            String temp = new String(array);
            add(map, word, temp);
            add(map, temp, word);
            array[i] = ch;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        n = beginWord.length();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : wordList) {
            addEdges(s, map);
        }
        addEdges(beginWord, map);
        int depth = 0;
        Deque<String> queue = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (s.equals(endWord)) {
                    return depth / 2 + 1;
                }
                for (String child : map.get(s)) {
                    if (visited.contains(child)) {
                        continue;
                    }
                    queue.offer(child);
                    visited.add(child);
                }
            }
            depth++;
        }
        return 0;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
