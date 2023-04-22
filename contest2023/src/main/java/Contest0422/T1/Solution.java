package Contest0422.T1;

import java.util.ArrayList;

/**
 * @author IronSid
 * @since 2023-04-22 14:59
 */
public class Solution {
    public int[] supplyWagon(int[] s) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(s[i]);
        }
        for (int i = 0; i < s.length - s.length / 2; i++) {
            int min = Integer.MAX_VALUE;
            int i1 = -1;
            for (int j = 0; j < list.size() - 1; j++) {
                int sum = list.get(j) + list.get(j + 1);
                if (sum < min) {
                    min = sum;
                    i1 = j;
                }
            }
            list.set(i1, min);
            list.remove(i1 + 1);
        }
        int[] res = new int[s.length / 2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}