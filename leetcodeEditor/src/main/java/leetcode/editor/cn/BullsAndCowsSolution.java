package leetcode.editor.cn;

import java.util.*;

/**
 * 猜数字游戏
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-08 13:43:34 
 */
public class BullsAndCowsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int len = secret.length();
        int[] cntSecret = new int[10];
        int[] cntGuess = new int[10];
        for (int i = 0; i < len; i++) {
            char sec = secret.charAt(i);
            char gue = guess.charAt(i);
            if (sec == gue) {
                bulls++;
            } else {
                cntSecret[sec - '0']++;
                cntGuess[gue - '0']++;
            }
        }
        for (int i = 0; i <= 9; i++) {
            cows += Math.min(cntSecret[i], cntGuess[i]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append('A').append(cows).append('B');
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
