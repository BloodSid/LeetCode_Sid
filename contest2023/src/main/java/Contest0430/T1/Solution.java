package Contest0430.T1;

/**
 * @author IronSid
 * @since 2023-04-30 10:34
 */
public class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = getScore(player1);
        int score2 = getScore(player2);
        if (score1 > score2) {
            return 1;
        } else if (score2 > score1) {
            return 2;
        } else {
            return 0;
        }
    }

    private int getScore(int[] p) {
        int sum = 0;
        for (int i = 0; i < p.length; i++) {
            if ((i >= 1 && p[i - 1] == 10) || (i >= 2 && p[i - 2] == 10)) {
                sum += 2 * p[i];
            } else {
                sum += p[i];
            }
        }
        return sum;
    }
}