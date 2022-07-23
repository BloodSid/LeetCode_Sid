package Contest0723.T1;

/**
 * @author IronSid
 * @since 2022-07-23 22:28
 */
public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int n = 5;
        int p1;
        for (p1 = 1; p1 < 5; p1++) {
            if (suits[p1] != suits[0]) break;
        }
        if (p1 == 5) return "Flush";
        int[] f = new int[14];
        int max = 0;
        for (int rank : ranks) {
            f[rank]++;
            max = Math.max(max, f[rank]);
        }
        if (max >= 3) return "Three of a Kind";
        if (max == 2) return "Pair";
        return "High Card";
    }
}
