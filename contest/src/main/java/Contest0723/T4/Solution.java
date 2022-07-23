package Contest0723.T4;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-07-23 22:30
 */
public class Solution {
    public int shortestSequence(int[] rolls, int k) {
       // 贪心
        HashSet<Integer> vis = new HashSet<>();
        int cnt = 0;
        for (int roll : rolls) {
            vis.add(roll);
            if (vis.size() == k) {
                vis.clear();
                cnt++;
            }
        }
        return cnt + 1;
    }
}
