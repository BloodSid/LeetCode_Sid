package Contest0703;

import linkedList.ListNode;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-07-03 11:32
 */
public class Solution {

    public String decodeMessage(String key, String message) {
        char[] kc = key.toCharArray();
        char[] map = new char[26];
        int p = 0;
        loop:
        for (int i = 0; i < kc.length; i++) {
            if (kc[i] == ' ') continue;
            for (int j = 0; j < i; j++) {
                if (kc[i] == kc[j]) {
                    continue loop;
                }
            }
            map[kc[i] - 'a'] = (char) (p + 'a');
            p++;
        }
        System.out.println(Arrays.toString(map));
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            chars[i] = map[chars[i] - 'a'];
        }
        return new String(chars);
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int xMin = 0, xMax = matrix.length - 1, yMin = 0, yMax = matrix[0].length - 1;
        int direction = 0;
        while (xMin <= xMax && yMin <= yMax) {
            direction %= 4;
            if (direction == 0) {
                for (int j = yMin; j <= yMax; j++) {
                    matrix[xMin][j] = head == null ? -1 : head.val;
                    if (head != null) head = head.next;
                }
                xMin++;
            } else if (direction == 1) {
                for (int i = xMin; i <= xMax; i++) {
                    matrix[i][yMax] = head == null ? -1 : head.val;
                    if (head != null) head = head.next;
                }
                yMax--;
            } else if (direction == 2) {
                for (int j = yMax; j >= yMin; j--) {
                    matrix[xMax][j] = head == null ? -1 : head.val;
                    if (head != null) head = head.next;
                }
                xMax--;
            } else {
                for (int i = xMax; i >= xMin; i--) {
                    matrix[i][yMin] = head == null ? -1 : head.val;
                    if (head != null) head = head.next;
                }
                yMin++;
            }
            direction++;
        }
        return matrix;
    }

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = (int) (1e9 + 7);
        long[][] dp = new long[n][forget];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            long t = 0;
            for (int k = delay - 1; k < forget - 1; k++) {
                t += dp[i - 1][k];
            }
            dp[i][0] = t % MOD;
            for (int j = 1; j < forget; j++) {
                dp[i][j] = dp[i - 1][j - 1];
            }
        }
        long sum = 0;
        for (int i = 0; i < forget; i++) {
            sum += dp[n - 1][i];
        }
        return (int) ((sum % MOD + MOD) % MOD);
    }
}
