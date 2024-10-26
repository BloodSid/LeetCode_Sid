package Contest0609.T1;

/**
 * @author IronSid
 * @since 2024-06-09 10:43
 */
public class Solution {
    public int numberOfChild(int n, int k) {
        int p = k / (n - 1);
        int q = k % (n - 1);
        if (p % 2 == 0) return q;
        return n - 1 - q;
    }
}
