package Contest0225.T4;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2024-02-25 10:31
 */
public class Solution {
    private int[] nums;
    private int[] changeIndices;
    private int n;
    private long slow;
    private int[] firstT;

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        this.nums = nums;
        this.changeIndices = changeIndices;
        n = nums.length;
        // 记录慢操作+标记所需天数
        slow = n;
        for (int num : nums) {
            slow += num;
        }
        firstT = new int[n];
        Arrays.fill(firstT, -1);
        for (int t = changeIndices.length - 1; t >= 0; t--) {
            firstT[changeIndices[t] - 1] = t;
        }
        int m = changeIndices.length;
        int l = 0, r = m - 1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l != m ? l + 1 : -1;
    }

    // 判断sec秒能不能标记全部下标。每个下标，要么用减一的方式慢操作到0，要么在changeIndices允许的时候直接快操作到0。
    boolean check(int sec) {
        // 因为允许什么也不做，所以用 cnt 记录可用秒数
        long cnt = 0;
        // 需要慢操作的秒数
        long s = slow;
        // 消耗时间短的在堆顶，堆中放进行快操作的下标
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        for (int t = sec; t >= 0; t--) {
            // 反悔贪心：在更靠左的时间进行快操作，但是如果之后遇到慢操作更耗时的下标需要时间标记，则反悔
            int i = changeIndices[t] - 1;
            int v = nums[i];
            if (t != firstT[i] || v <= 1) {
                // 如果可以更早快操作i或者对i进行快操作不更快，则把时间留给左边决定
                cnt++;
            } else {
                if (cnt == 0) {
                    // 没有可用时间，尝试反悔一个慢操作更耗时的下标
                    if (!pq.isEmpty() && nums[pq.peek()] < nums[i]) {
                        // 弹出的下标相当于用更左侧的时间进行慢操作
                        int p = pq.poll();
                        s += nums[p] + 1;
                        // 反悔出两秒，一秒原用于标记，一秒原用于快操作
                        cnt += 2;
                    }
                }
                if (cnt > 0) {
                    // 有可用时间，对i进行快操作，并消耗一个可用时间进行标记
                    cnt--;
                    pq.offer(i);
                    s -= v + 1;
                } else {
                    // 没有可用时间，把时间留给左边使用，i需进行慢操作
                    cnt++;
                }
            }
        }
        // 剩余可用时间足够慢操作+标记
        return s <= cnt;
    }
}
