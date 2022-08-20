package Contest0820.T1;

/**
 * @author IronSid
 * @since 2022-08-20 22:29
 */
public class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] ch = blocks.toCharArray();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + k <= ch.length; i++) {
            int cnt = 0;
            for (int j = 0; j < k; j++) {
                if (ch[i + j] == 'W') cnt++;
            }
            min = Math.min(min, cnt);
        }
        return min;
    }
}
