package Contest1022.T3;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-10-22 15:03
 */
public class Solution {
    public int[] arrangeBookshelf(int[] order, int limit) {
        HashMap<Integer, Integer> f = new HashMap<>();
        int[] res = new int[order.length];
        int p = 0;
        for (int i : order) {
            f.put(i, f.getOrDefault(i, 0) + 1);
        }
        HashMap<Integer, Integer> inStack = new HashMap<>();
        for (int e : order) {
            // 该元素数量已经到达上限，必须删除
            if (inStack.getOrDefault(e, 0) == limit) {
                f.put(e, f.get(e) - 1);
                continue;
            }
            // 和栈顶的元素比较，把栈顶更大且可以删除的元素全部删除
            while (p > 0 && e < res[p - 1] && f.get(res[p - 1]) > limit) {
                int peek = res[p - 1];
                f.put(peek, f.get(peek) - 1);
                inStack.put(peek, inStack.get(peek) - 1);
                p--;
            }
            // 当前元素入栈
            res[p++] = e;
            inStack.put(e, inStack.getOrDefault(e, 0) + 1);
        }
        return Arrays.copyOf(res, p);
    }
}
