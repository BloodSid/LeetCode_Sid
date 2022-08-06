package Contest0806.T3;

import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-08-06 19:15
 */
public class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long res = 0;
        HashMap<Integer, Long> last = new HashMap<>();
        for (int task : tasks) {
            if (last.containsKey(task) && res - last.get(task) <= space) {
                res = last.get(task) + space + 1;
            }
            last.put(task, res);
            res++;
        }
        return res;
    }
}
