package leetcode.editor.cn;

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
    // 提交时声明为静态
    private final int[] q = new int[10010];
    int rear, head;

    public RecentCounter() {
        rear = 0;
        head = 0;
    }
    
    public int ping(int t) {
        q[rear++] = t;
        while (head < rear && q[head] < t - 3000) {
            head++;
        }
        return rear - head;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
