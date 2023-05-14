package Contest0514.T1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-05-14 16:44
 */
public class Solution {
    public int[] circularGameLosers(int n, int k) {
        int[] f = new int[n + 1];
        int p = 1;
        for (int i = 0; ; i++) {
            p = (p + i * k + n - 1) % n + 1;
            f[p]++;
            if (f[p] == 2) break;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
           if (f[i] == 0) list.add(i);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}