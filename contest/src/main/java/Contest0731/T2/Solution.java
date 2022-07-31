package Contest0731.T2;

/**
 * @author IronSid
 * @since 2022-07-31 10:29
 */
public class Solution {
    public int maximumGroups(int[] grades) {
        // 贪心，所有的成绩从小到大排，然后从前往后分组，每组人数依次为 1，2，3...
        int n = grades.length;
        int l = 1, r = n;
        while (l <= r) {
            long mid = l + r >> 1;
            if (mid * (mid + 1) / 2 <= n) {
                l = (int) (mid + 1);
            } else {
                r = (int) (mid - 1);
            }
        }
        return r;
    }
}
