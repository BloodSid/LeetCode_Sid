package leetcode.editor.cn;

import java.util.*;

/**
 * 最近的请求次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-06 23:24:16 
 */
public class NumberOfRecentCallsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class RecentCounter {

    private final Deque<Integer> q = new ArrayDeque<>();

    public RecentCounter() {
    }
    
    public int ping(int t) {
        q.offer(t);
        while (!q.isEmpty() && q.peek() < t - 3000) {
            q.poll();
        }
        return q.size();
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
