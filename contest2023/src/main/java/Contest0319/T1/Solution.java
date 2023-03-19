package Contest0319.T1;

public class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        for (int i = 0; ; i++) {
            if ((n >> i & 1) == 1) {
                res[i % 2]++;
            }
            if (n >> i == 0) break;
        }
        return res;
    }
}
