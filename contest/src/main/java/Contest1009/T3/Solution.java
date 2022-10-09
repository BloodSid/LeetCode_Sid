package Contest1009.T3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author IronSid
 * @since 2022-10-09 10:28
 */
public class Solution {
    public String robotWithString(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int n = ch.length;
        char[] min = new char[n];
        min[n - 1] = ch[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            min[j] = (char) Math.min(min[j + 1], ch[j]);
        }
        char[] res = new char[n];
        int p = 0;
        Deque<Character> stack = new ArrayDeque<>();
        // 贪心 每次找最小的字符
        while (i < n) {
            while (!stack.isEmpty() && stack.peek() <= min[i]) {
                res[p++] = stack.pop();
            }
            char t = min[i];
            while (i < n) {
                stack.push(ch[i]);
                if (ch[i++] == t) {
                    break;
                }
            }
        }
        while (!stack.isEmpty()) {
            res[p++] = stack.pop();
        }
        return new String(res);
    }
}
