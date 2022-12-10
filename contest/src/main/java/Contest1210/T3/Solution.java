package Contest1210.T3;

/**
 * @author IronSid
 * @since 2022-12-10 22:29
 */
public class Solution {
    public int maxJump(int[] stones) {
        if (stones.length == 2) return stones[1] - stones[0];
        // 贪心, 把石头交替分配给来路和去路
        int c1 = stones[1];
        int i = 0;
        int n = stones.length;
        for (i = 3; i < n; i += 2) {
            c1 = Math.max(c1, stones[i] - stones[i - 2]);
        }
        int c2 = stones[2];
        for (i = 4; i < n; i += 2) {
            c2 = Math.max(c2, stones[i] - stones[i - 2]);
        }
        if (n % 2 == 1) {
            c1 = Math.max(c1, stones[n - 1] - stones[n - 2]);
        } else {
            c2 = Math.max(c2, stones[n - 1] - stones[n - 2]);
        }
        return Math.max(c1, c2);
    }
}
