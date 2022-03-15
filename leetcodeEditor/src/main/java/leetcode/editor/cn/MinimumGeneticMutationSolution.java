package leetcode.editor.cn;

import java.util.*;

/**
 * 最小基因变化
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-15 21:34:38 
 */
public class MinimumGeneticMutationSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashSet<String> set;
    private String end;
    // 四种碱基
    char[] bases = {'A', 'C', 'G', 'T'};
    // 每条序列长度为8
    public static final int N = 8;

    public int minMutation(String start, String end, String[] bank) {
        this.end = end;
        set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        return dfs(start);
    }

    int dfs(String s) {
        if (s.equals(end)) {
            return 0;
        }
        set.remove(s);
        for (int i = 0; i < N; i++) {
            char cur = s.charAt(i);
            for (char base : bases) {
                if (base != cur) {
                    String next = s.substring(0, i) + base + s.substring(i + 1);
                    if (set.contains(next)) {
                        int temp = dfs(next);
                        if (temp != -1) {
                            return temp + 1;
                        }
                    }
                }
            }
        }
        set.add(s);
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
