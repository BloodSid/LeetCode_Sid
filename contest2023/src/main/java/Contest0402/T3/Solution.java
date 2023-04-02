package Contest0402.T3;

import java.util.Arrays;

public class Solution {
    public int miceAndCheese(int[] r1, int[] r2, int k) {
        long sum = 0;
        int n = r1.length;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = r2[i] - r1[i];
            sum += r1[i];
        }
        Arrays.sort(d);
        for (int i = 0; i < n - k; i++) {
            sum += d[n - 1 - i];
        }
        return (int) sum;
    }
}
