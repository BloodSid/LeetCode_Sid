package Contest1126.T1;

/**
 * @author IronSid
 * @since 2022-11-26 22:25
 */
public class Solution {
    public int numberOfCuts(int n) {
        if (n == 1) return 1;
        return n % 2 == 0 ? n / 2 : n;
    }
}
