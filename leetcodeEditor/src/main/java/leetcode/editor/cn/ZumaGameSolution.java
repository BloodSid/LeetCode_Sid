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
    // 球的颜色有 BGRWY
    char[] color = "BGRWY".toCharArray();
    char[] hand;
    int m;
    Map<String, Integer> map;

    public int findMinStep(String board, String hand) {
        this.hand = hand.toCharArray();
        Arrays.sort(this.hand);
        m = hand.length();
        map = new HashMap<>();
        return findMinStep(board, (1 << m) - 1);
    }

    int findMinStep(String board, int status) {
        if (board.length() == 0) {
            return 0;
        }
        if (status == 0) {
            return -1;
        }
        if (map.containsKey(board)) {
            return map.get(board);
        }
        int n = board.length();
        char[] arr = board.toCharArray();
        int minStep = Integer.MAX_VALUE;
        char cur = 0;
        for (int i = 0; i < m; i++) {
            // 该bit对应的球已经用过则跳过
            if (((1 << (m - 1 - i)) & status) == 0) {
                continue;
            }
            // 和上一次用的球相同则跳过
            if (hand[i] == cur) {
                continue;
            }
            cur = hand[i];
            // 遍历插入位置
            for (int j = 0; j <= n; j++) {
                // 用cur, left, right 分别代表插入的，插入位置左右的球
                // 在几个连续的相同颜色球的开始，结束和中间插入同一颜色的球，结果是一样的。
                // 现规定遇到这种情况的时候只在最左边插入，即cur不等于left
                if (j > 0 && arr[j - 1] == cur) {
                    continue;
                }
                String newBoard = null;
                // cur 等于 right
                if (j < n && arr[j] == cur) {
                    newBoard = insertBall(arr, j, cur);
                    newBoard = removeConsecutiveBalls(newBoard, j);
                }
                // cur 即不等于left, 也不等于right
                // left right 相同时，可能因为本次插入把l&r拆分到不同的组合里消除，可能得到更优解
                // left right 不同时，该次插入不影响消除组合，不能得到更优解，不予考虑
                if (j > 0 && j < n && arr[j - 1] != cur && arr[j - 1] == arr[j]) {
                    newBoard = insertBall(arr, j, cur);
                }
                if (newBoard == null) {
                    continue;
                }
                int subStep = findMinStep(newBoard, status - (1 << (m - 1 - i)));
                if (subStep != -1) {
                    minStep = Math.min(minStep, subStep + 1);
                }
            }
        }
        if (minStep == Integer.MAX_VALUE) {
            map.put(board, -1);
            return -1;
        } else {
            map.put(board, minStep);
            return minStep;
        }
    }

    String removeConsecutiveBalls(String board, int i) {
        char[] arr = board.toCharArray();
        int left = i;
        // 按照插入规则，插入点的右边必有球
        int right = i + 1;
        char cur = arr[left];
        int gapLen = 0;
        do {
            int l = left;
            while (l > 0 && arr[l - 1] == cur) {
                l--;
            }
            int r = right;
            while (r < arr.length - 1 && arr[r + 1] == cur) {
                r++;
            }
            // (left - l + 1) + (r - right + 1) > 2 时同色的超过3个，消除l到r
            if (r - l + 1 - gapLen <= 2) {
                break;
            } else {
                left = l;
                right = r;
                gapLen = r - l + 1;
            }
            if (left > 0) {
                cur = arr[left - 1];
            }
        } while ((left > 0 && right < arr.length - 1));
        if (left + 1 == right) {
            return board;
        } else {
            return new StringBuilder().append(arr, 0, left)
                    .append(arr, right + 1, arr.length - right - 1)
                    .toString();
        }
    }

    String insertBall(char[] board, int postion, char ball) {
        return new StringBuilder().append(board, 0, postion)
                .append(ball)
                .append(board, postion, board.length - postion)
                .toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
