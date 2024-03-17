package Contest0317.T2;

/**
 * @author IronSid
 * @since 2024-03-17 10:22
 */
public class Solution {
    public long countSubstrings(String s, char c) {
        long f = 0;
        for (char c1 : s.toCharArray()) {
            if (c1 == c) f++;
        }
        return f * (f + 1) / 2;
    }
}
