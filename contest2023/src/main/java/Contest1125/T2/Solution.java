package Contest1125.T2;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-10-28 22:33
 */
public class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int d1 = 0, d2 = 0;
        // 找出最长连续的编号
        for (int i = 0, t = 1; i < hBars.length; i++) {
            if (i > 0 && hBars[i] == hBars[i - 1] + 1) {
                t++;
            } else {
                t = 1;
            }
            d1 = Math.max(d1, t);
        }
        for (int i = 0, t = 1; i < vBars.length; i++) {
            if (i > 0 && vBars[i] == vBars[i - 1] + 1) {
                t++;
            } else {
                t = 1;
            }
            d2 = Math.max(d2, t);
        }
        int min = Math.min(d1, d2) + 1;
        return min * min;
    }
}
