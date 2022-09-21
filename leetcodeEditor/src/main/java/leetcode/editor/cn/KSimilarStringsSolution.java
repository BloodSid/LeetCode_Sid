package leetcode.editor.cn;
//对于某些非负整数 k ，如果交换 s1 中两个字母的位置恰好 k 次，能够使结果字符串等于 s2 ，则认为字符串 s1 和 s2 的 相似度为 k 。 
//
// 给你两个字母异位词 s1 和 s2 ，返回 s1 和 s2 的相似度 k 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab", s2 = "ba"
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abc", s2 = "bca"
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length <= 20 
// s2.length == s1.length 
// s1 和 s2 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母 
// s2 是 s1 的一个字母异位词 
// 
// 👍 211 👎 0


import java.util.*;

/**
 * 相似度为 K 的字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-21 16:09:26 
 */
public class KSimilarStringsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        Deque<Node> q = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        q.offer(new Node(s1, 0));
        vis.add(s1);
        int step = 0;
        // 广度优先搜索
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                String s = poll.s;
                int idx = poll.idx;
                if (s2.equals(s)) return step;
                while (idx < n && s.charAt(idx) == s2.charAt(idx)) idx++;
                for (int j = idx + 1; j < n; j++) {
                    if (s2.charAt(j) == s.charAt(j)) continue;
                    if (s2.charAt(idx) == s.charAt(j)) {
                        String next = swap(s, idx, j);
                        if (vis.contains(next)) continue;
                        vis.add(next);
                        q.offer(new Node(next, idx + 1));
                    }
                }
            }
            step++;
        }
        return -1;
    }

    String swap(String original, int a, int b) {
        char[] ch = original.toCharArray();
        char t = ch[a]; ch[a] = ch[b]; ch[b] = t;
        return new String(ch);
    }
}

class Node {
    String s;
    int idx;

    public Node(String s, int idx) {
        this.s = s;
        this.idx = idx;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
