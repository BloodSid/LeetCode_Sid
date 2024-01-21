package Contest0121.T3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2024-01-21 10:27
 */
public class Solution {
    public int minimumPushes(String word) {
        int[] f = new int[128];
        for (char c : word.toCharArray()) {
            f[c]++;
        }
        // 贪心，把更大的频数优先分到8个按键上
        List<Integer> list = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            if (f[c] != 0) {
                list.add(f[c]);
            }
        }
        // 贪心，把更大的频数优先分到8个按键上
        list.sort((a, b) -> b - a);
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += (i / 8 + 1) * list.get(i);
        }
        return res;
    }
}