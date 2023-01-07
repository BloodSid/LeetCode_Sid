package Contest0107.T2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author IronSid
 * @since 2023-01-07 22:35
 */
public class DataStream {

    private int value;
    private final Deque<Integer> q;
    private int k;
    // 队列中等于 value 的个数
    private int cnt;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        q = new ArrayDeque<>(k);
        cnt = 0;
    }

    public boolean consec(int num) {
        if (q.size() == k) {
            int p = q.poll();
            if (p == value) cnt--;
        }
        q.offer(num);
        if (num == value) cnt++;
        return cnt == k;
    }
}