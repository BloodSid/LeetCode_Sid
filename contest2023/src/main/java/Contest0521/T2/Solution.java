package Contest0521.T2;

/**
 * @author IronSid
 * @since 2023-05-21 10:21
 */
public class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0, j = ch.length - 1; i < j; i++, j--) {
            if (ch[i] != ch[j]) {
                ch[i] = ch[j] = (char) Math.min(ch[i], ch[j]);
            }
        }
        return new String(ch);
    }
}