package Contest1022.T3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author IronSid
 * @since 2022-10-22 15:03
 */
public class Solution {
    public int[] arrangeBookshelf(int[] order, int limit) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i : order) {
            f.put(i, f.getOrDefault(i, 0) + 1);
        }
        int remain = 0;
        for (Integer value : f.values()) {
            remain += Math.min(value, limit);
        }
        int[] res = new int[remain];
        // 需要去掉的元素集合
        HashMap<Integer, Integer> status = new HashMap<>();
        for (Map.Entry<Integer, Integer> e : f.entrySet()) {
            status.put(e.getKey(), Math.max(e.getValue() - limit, 0));
        }
        // 贪心每次都选最小的那个元素
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            int minIdx = 0;
            int minVal = Integer.MAX_VALUE;
            HashMap<Integer, Integer> minStatus = null;
            for (; j < order.length; j++) {
                if (order[j] < minVal) {
                    minIdx = j;
                    minVal = order[j];
                    System.out.println(status);
                    minStatus = new HashMap<>(status);
                }
                if (status.get(order[j]) == 0) break;
                status.put(order[j], status.get(order[j]) - 1);
            }
            res[i] = order[minIdx];
            status = minStatus;
            j = minIdx + 1;
        }
        return res;
    }
}
