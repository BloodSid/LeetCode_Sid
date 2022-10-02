package Contest1002.T3;

/**
 * @author IronSid
 * @since 2022-10-02 10:36
 */
public class Solution {
    public int minimizeXor(int num1, int num2) {
        int b1 = Integer.bitCount(num1);
        int b2 = Integer.bitCount(num2);
        if (b1 >= b2) {
            int t = num1;
            for (int i = 0; i < b2; i++) {
                t ^= Integer.highestOneBit(t);
            }
            return t ^ num1;
        } else {
            int[] bits = new int[32];
            for (int i = 0; i < 32; i++) {
                if ((num1 & 1 << i) != 0) bits[i] = 1;
            }
            int d = b2 - b1;
            for (int i = 0; i < 32; i++) {
                if (bits[i] == 0) {
                    if (--d >= 0) bits[i] = 1;
                } else {
                    bits[i] = 0;
                }
            }
            int t = 0;
            for (int i = 0; i < 32; i++) {
                t |= bits[i] << i;
            }
            return t ^ num1;
        }
    }
}
