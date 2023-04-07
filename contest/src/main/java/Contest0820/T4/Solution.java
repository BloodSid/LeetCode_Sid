package Contest0820.T4;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author IronSid
 * @since 2022-08-20 22:30
 */
public class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        // TODO 并查集
        int n = nums.length;
        long[] pre = new long[n + 1];
        long t = 0;
        for (int i = 0; i < n; i++) {
            t += nums[i];
            pre[i + 1] = t;
        }
        // 位置从左到右排
        TreeSet<int[]> pos = new TreeSet<>(Comparator.comparingInt(o -> o[0]));
        // p[i] = [0, i); p[j + 1] - p[i] = [i , j + 1]
        // 子段和从大到小排
        TreeSet<int[]> sum = new TreeSet<>(Comparator.comparingLong((int[] o) -> - pre[o[1] + 1] + pre[o[0]])
                .thenComparingInt(o -> o[0]));
        int[] origin = {0, n - 1};
        pos.add(origin);
        sum.add(origin);
        long[] res = new long[n];
        for (int i = 0; i < removeQueries.length - 1; i++) {
            int remove = removeQueries[i];
            int[] change = pos.floor(new int[]{remove, remove});
            pos.remove(change);
            sum.remove(change);
            int[] add1 = null, add2 = null;
            if(remove != change[0]) add1 = new int[]{change[0], remove - 1};
            if(remove != change[1]) add2 = new int[]{remove + 1, change[1]};
            if (add1 != null) {
                pos.add(add1);
                sum.add(add1);
            }
            if (add2 != null) {
                pos.add(add2);
                sum.add(add2);
            }
            int[] first = sum.first();
            res[i] = pre[first[1] + 1] - pre[first[0]];
        }
        return res;
    }
}
