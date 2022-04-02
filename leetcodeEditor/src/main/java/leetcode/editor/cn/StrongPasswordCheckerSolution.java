package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

/**
 * 强密码检验器
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-02 17:52:41
 */
public class StrongPasswordCheckerSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private StringBuilder sb;
    public static final int UPPER = 0;
    public static final int LOWER = 1;
    public static final int DIGIT = 2;
    private boolean[] has;
    int[] dp = new int[50];

    public int strongPasswordChecker(String password) {
        has = new boolean[3];
        sb = new StringBuilder(password);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (Character.isUpperCase(ch)) {
                has[UPPER] = true;
            } else if (Character.isLowerCase(ch)) {
                has[LOWER] = true;
            } else if (Character.isDigit(ch)) {
                has[DIGIT] = true;
            }
        }
        int operation = 0;
        // 把出现重复字符的都改掉
        for (int pos = getDupPos(); pos != -1; pos = getDupPos(), operation++) {
            // 长于20的用删除，删除不影响类型
            if (sb.length() > 20) {
                sb.deleteCharAt(pos);
                continue;
            }
            // 短于6的插入，长度合适的用修改(先删除，再插入)
            if (sb.length() >= 6) sb.deleteCharAt(pos);
            switch (need()) {
                case UPPER:
                    sb.insert(pos, 'A');
                    has[UPPER] = true;
                    break;
                case LOWER:
                    sb.insert(pos, 'a');
                    has[LOWER] = true;
                    break;
                case DIGIT:
                    sb.insert(pos, '0');
                    has[DIGIT] = true;
                    break;
                default:
                    sb.insert(pos, getChar('0', pos));
            }
        }
        // 长度小于6：长度5，至少两种字符，再加另外一种。所以可以通过添加达到所有的字符类型，不再计算缺乏什么类型
        if (sb.length() < 6) {
            return operation + 6 - sb.length();
        }
        // 长度大于20：存在删去一部分字符而且不影响类型的方法
        if (sb.length() > 20) {
            operation += sb.length() - 20;
        }
        // 若还有缺乏的字符类型，可进行修改操作
        while (need() != -1) {
            has[need()] = true;
            operation++;
        }
        return operation;
    }

    // 计算第一个字符重复3次的出现位置，若未出现，则返回-1
    int getDupPos() {
        int n = sb.length();
        // 记录连续字符最后出现的地方
        List<Integer> ends = new LinkedList<>();
        int t = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && sb.charAt(i) == sb.charAt(i - 1)) {
                t++;
            } else {
                if (t >= 3) {
                    ends.add(i - 1);
                }
                t = 1;
            }
            dp[i] = t;
        }
        if (t >= 3) ends.add(n - 1);
        if (ends.isEmpty()) return -1;
        // 如果同时有长度5和长度6的连续字符，则应该优先在长度6的中间删一个
        for (Integer end : ends) {
            if (dp[end] % 3 == 0) {
                return end - dp[end] + 3;
            }
        }
        for (Integer end : ends) {
            if (dp[end] % 3 == 1) {
                return end - dp[end] + 3;
            }
        }
        int end = ends.get(0);
        return end - dp[end] + 3;
    }

    // 缺哪种字符
    int need() {
        for (int i = 0; i < 3; i++) {
            if (!has[i]) {
                return i;
            }
        }
        return -1;
    }

    // 计算适合插入的字符
    char getChar(char ch, int pos) {
        for (; (pos >= 1 && ch == sb.charAt(pos - 1)) || (pos < sb.length() && ch == sb.charAt(pos)); ch++) {}
        return ch;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
