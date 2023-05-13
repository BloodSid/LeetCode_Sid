package Contest0513.T1;

/**
 * @author IronSid
 * @since 2023-05-13 22:29
 */
public class Solution {
    public int countSeniors(String[] details) {
        int cnt = 0;
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11, 13)) > 60) {
                cnt++;
            }
        }
        return cnt;
    }
}
