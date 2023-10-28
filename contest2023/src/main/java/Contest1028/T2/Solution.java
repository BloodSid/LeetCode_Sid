package Contest1028.T2;

/**
 * @author IronSid
 * @since 2023-10-28 22:38
 */
public class Solution {
    public int minChanges(String s) {
        int res = 0;
        char[] c = s.toCharArray();
        // 对分组长度贪心，以2组长度分组，只要2个字符不同必修改
        for (int i = 0; i < c.length; i += 2) {
            res += c[i] ^ c[i + 1];
        }
        return res;
    }
}
