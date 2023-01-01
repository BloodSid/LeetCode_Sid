package Contest0101.T3;

/**
 * @author IronSid
 * @since 2023-01-01 10:36
 */
public class Solution {
    public int minimumPartition(String s, int k) {
        int cnt = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (Long.parseLong(s.substring(j, j + 1)) > k) return -1;
            if (Long.parseLong(s.substring(i, j + 1)) <= k) {

            } else {
                i = j;
                cnt++;
            }
        }
        return cnt + 1;
    }
}
