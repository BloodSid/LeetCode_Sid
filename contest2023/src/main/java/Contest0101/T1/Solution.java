package Contest0101.T1;

/**
 * @author IronSid
 * @since 2023-01-01 10:36
 */
public class Solution {
    public int countDigits(int num) {
        int t = num;
        int cnt = 0;
        while (t > 0) {
            if (num % (t % 10) == 0) cnt++;
            t /= 10;
        }
        return cnt;
    }
}
