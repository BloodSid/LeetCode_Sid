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
    private HashMap<String, List<String>> map;

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
        map = new HashMap<>();
        for (String s : wordList) {
            addEdges(s, map);
        }
        addEdges(beginWord, map);
        if (!map.containsKey(endWord)) return 0;
        int depth = 0;
        Deque<String> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        HashSet<String> v1 = new HashSet<>(), v2 = new HashSet<>();
        q1.offer(beginWord);
        q2.offer(endWord);
        v1.add(beginWord);
        v2.add(endWord);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size() ? update(q2, v2, v1) : update(q1, v1, v2)) {
                return depth / 2 + 1;
            }
            depth++;
        }
        return 0;
    }

    boolean update(Deque<String> queue, Set<String> cur, Set<String> another){
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            String s = queue.poll();
            if (another.contains(s)) {
                return true;
            }
            for (String child : map.get(s)) {
                if (cur.contains(child)) {
                    continue;
                }
                queue.offer(child);
                cur.add(child);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
