package Contest0820.T2;

/**
 * @author IronSid
 * @since 2022-08-20 22:30
 */
public class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        boolean flag = true;
        int second = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < n - 1;) {
                if (ch[i] == '0' && ch[i + 1] == '1') {
                    ch[i] = '1';
                    ch[i + 1] = '0';
                    flag = true;
                    i += 2;
                } else {
                    i++;
                }
            }
            if (flag) second++;
        }
        return second;
    }
}
