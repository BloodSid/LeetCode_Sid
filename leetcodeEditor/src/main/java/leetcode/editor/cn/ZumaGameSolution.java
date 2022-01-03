package leetcode.editor.cn;

import java.util.*;

/**
 * 祖玛游戏
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-01 20:53:31
 */
public class ZumaGameSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[] color = "RYBGW".toCharArray();
    Map<Character, Integer> colorMap;

    public int findMinStep(String board, String hand) {
        // 球的颜色有 RYBGW
        int[] count = new int[color.length];
        colorMap = new HashMap<>();
        for (int i = 0; i < color.length; i++) {
            colorMap.put(color[i], i);
        }
        for (char c : hand.toCharArray()) {
            count[colorMap.get(c)]++;
        }
        StringBuilder sb = new StringBuilder(board);
        return findMinStep(sb, hand.length(), count);
    }

    int findMinStep(StringBuilder board, int sum, int[] count) {
        if (board.length() == 0) {
            return 0;
        }
        if (sum == 0 && board.length() != 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int len = board.length();
        for (int i = 0; i <= board.length(); i++) {
            for (int j = 0; j < color.length; j++) {
                if (count[j] == 0) {
                    continue;
                }
                StringBuilder newBoard = new StringBuilder(board);
                newBoard.insert(i, color[j]);
                count[j]--;
                if ((i > 0 && newBoard.charAt(i - 1) == color[j]) || (i < len && newBoard.charAt(i + 1) == color[j])) {
                    removeConsecutiveBalls(newBoard);
                }
                int step = findMinStep(newBoard, sum - 1, count);
                if (step != -1) {
                    min = Math.min(min, step);
                }
                count[j]++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min + 1;
    }

    int maxBoardLength = 16;
    int maxHandLength = 5;
    int[] dp = new int[maxBoardLength + maxHandLength];

    void removeConsecutiveBalls(StringBuilder board) {
        while (board.length() > 0) {
            int len = board.length();
            int max = 1;
            int maxIndex = 0;
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                if (board.charAt(i) == board.charAt(i - 1)) {
                    dp[i] = dp[i - 1] + 1;
                    if (dp[i] > max) {
                        max = dp[i];
                        maxIndex = i;
                    }
                } else {
                    dp[i] = 1;
                }
            }
            if (max < 3) {
                break;
            }
            board.delete(maxIndex - dp[maxIndex] + 1, maxIndex + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
