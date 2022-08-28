package Contest0828.T3;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-08-28 0:33
 */
public class Solution {

    public static final int M = 0;
    public static final int P = 1;
    public static final int G = 2;

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length;
        int ans = 0;
        int[] cnt = new int[3];
        int[] last = new int[3];
        Arrays.fill(last, -1);
        for (int i = 0; i < garbage.length; i++) {
            char[] ch = garbage[i].toCharArray();
            for (char c : ch) {
                if (c == 'M') {
                    cnt[M]++;
                    last[M] = i;
                }
                else if (c == 'P') {
                    cnt[P]++;
                    last[P] = i;
                }
                else if (c == 'G') {
                    cnt[G]++;
                    last[G] = i;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            ans += cnt[i];
            for (int j = 0; j < last[i]; j++) {
                ans += travel[j];
            }
        }
        return ans;
    }
}
