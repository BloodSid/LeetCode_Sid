package Contest0918.T1;

/**
 * @author IronSid
 * @since 2022-09-18 10:28
 */
public class Solution {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 1 ? 2 * n : n;
    }
}
