package Contest1210.T1;

/**
 * @author IronSid
 * @since 2022-12-10 22:29
 */
public class Solution {
    public int maximumValue(String[] strs) {
        int max = 0;
        for (String str : strs) {
            if (str.matches("\\d+")) {
                max = Math.max(max, Integer.parseInt(str));
            } else {
                max = Math.max(max, str.length());
            }
        }
        return max;
    }
}
