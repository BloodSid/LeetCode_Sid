package Contest1015.T1;

/**
 * @author IronSid
 * @since 2022-10-15 22:31
 */
public class Solution {
    public int countTime(String time) {
        int cnt = 0;
        char[] ch = time.toCharArray();
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                int a = i / 10;
                int b = i % 10;
                int c = j / 10;
                int d = j % 10;
                if ((ch[0] == '?' || ch[0] == a + '0') && (ch[1] == '?' || ch[1] == b + '0') && (ch[3] == '?' || ch[3] == c + '0') && (ch[4] == '?' || ch[4] == d + '0')) cnt++;
            }
        }
        return cnt;
    }
}
