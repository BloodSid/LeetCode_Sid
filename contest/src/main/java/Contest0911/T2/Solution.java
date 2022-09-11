package Contest0911.T2;

/**
 * @author IronSid
 * @since 2022-09-11 10:37
 */
public class Solution {
    public int partitionString(String s) {
        char[] ch = s.toCharArray();
        int status = 0;
        int cnt = 0;
        for (char c : ch) {
            int i = c - 'a';
            if ((1 << i & status) == 0) {
                status |= 1 << i;
            } else {
                status = 1 << i;
                cnt++;
            }
        }
        return cnt + 1;
    }
}
