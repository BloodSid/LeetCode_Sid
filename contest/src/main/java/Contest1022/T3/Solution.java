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
        // 贪心地选最小的那个元素，即考虑 order[j] 之后可以合法的去除的子序列中，去除了哪个子序列后下一个元素最小
        int j = 0;
        for (int i = 0; i < res.length; i++) {
            int minIdx = 0;
            int minVal = Integer.MAX_VALUE;
            HashMap<Integer, Integer> minStatus = null;
            HashMap<Integer, Integer> minF = null;
            // 遍历 j 起合法的下一个元素
            for (; j < order.length; j++) {
                // 若该元素需要删除的数量等于剩下部分中的数量则必删除
                if (status.get(order[j]) == f.get(order[j])) continue;
                if (order[j] < minVal) {
                    minIdx = j;
                    minVal = order[j];
                    minStatus = new HashMap<>(status);
                    minF = new HashMap<>(f);
                }
                // 若该元素需要的删除数量已达到，则该元素不能被删，终止循环
                if (status.get(order[j]) == 0) break;
                status.put(order[j], status.get(order[j]) - 1);
                f.put(order[j], f.get(order[j]) - 1);
            }
            // 当前位置取最小元素，并复原状态到最小元素的位置
            res[i] = order[minIdx];
            status = minStatus;
            j = minIdx + 1;
            f = minF;
            f.put(order[minIdx], f.get(order[minIdx]) - 1);
        }
        return res;
    }
}
