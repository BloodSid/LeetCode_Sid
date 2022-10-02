package Contest1002.T1;

/**
 * @author IronSid
 * @since 2022-10-02 10:33
 */
public class Solution {
    public int commonFactors(int a, int b) {
        int cnt = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) cnt++;
        }
        return cnt;
    }
}
