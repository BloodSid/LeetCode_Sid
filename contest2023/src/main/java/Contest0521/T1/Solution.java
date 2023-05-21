package Contest0521.T1;

/**
 * @author IronSid
 * @since 2023-05-21 10:21
 */
public class Solution {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");
            s = s.replace("CD", "");
        }
        return s.length();
    }
}
