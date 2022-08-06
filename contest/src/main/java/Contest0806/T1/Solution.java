package Contest0806.T1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-08-06 19:15
 */
public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] h = new int[1001];
        calc(h, items1);
        calc(h, items2);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < h.length; i++) {
            if (h[i] != 0) {
                List<Integer> cur = new ArrayList<>();
                cur.add(i);
                cur.add(h[i]);
                list.add(cur);
            }
        }
        return list;
    }

    void calc(int[] h, int[][] items) {
        for (int[] item : items) {
            h[item[0]] += item[1];
        }
    }
}
