package Contest0916.T3;

import java.util.HashMap;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-09-16 22:21
 */
public class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int n = coordinates.size();
        int sum = 0;
        HashMap<Integer, HashMap<Integer, Integer>> f = new HashMap();
        for (int i = 0; i < n; i++) {
            int x = coordinates.get(i).get(0);
            int y = coordinates.get(i).get(1);
            // 对于该点枚举x和y方向的距离
            for (int dx = 0; dx <= k; dx++) {
                int dy = k - dx;
                int x2 = x ^ dx, y2 = y ^ dy;
                if (f.containsKey(x2)) sum += f.get(x2).getOrDefault(y2, 0);
            }
            // 将该点加入
            f.computeIfAbsent(x, kk -> new HashMap<>()).merge(y, 1, Integer::sum);
        }
        return sum;
    }
}