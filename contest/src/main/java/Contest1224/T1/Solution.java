package Contest1224.T1;

/**
 * @author IronSid
 * @since 2022-12-24 23:10
 */
public class Solution {
    public int captureForts(int[] forts) {
        Integer last = null;
        int max = 0;
        for (int i = 0, t = 0; i < forts.length; i++) {
            if (forts[i] == 0) {
                t++;
            } else {
                if (last != null && last * forts[i] == -1) {
                    max = Math.max(max, t);
                }
                last = forts[i];
                t = 0;
            }
        }
        return max;
    }
}
