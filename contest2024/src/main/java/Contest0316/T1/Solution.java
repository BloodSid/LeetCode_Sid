package Contest0316.T1;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-03-16 22:26
 */
public class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += encrypt(num);
        }
        return res;
    }

    int encrypt(int x) {
        String s = String.valueOf(x);
        char[] ch = s.toCharArray();
        char mx = 0;
        for (char c : ch) {
            mx = (char) Math.max(mx, c);
        }
        Arrays.fill(ch, mx);
        return Integer.parseInt(new String(ch));
    }
}
