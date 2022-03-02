package leetcode.editor.cn;

import java.util.*;

/**
 * 寻找最近的回文数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-02 20:04:46
 */
public class FindTheClosestPalindromeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);
        // 大多数情况下一个数最近的回文数和它本身的位数是相同的
        long nearest = 0;
        long minDiff = Long.MAX_VALUE;
        long left = Long.parseLong(n.substring(0, (len + 1) / 2));
        int[] offset = {-1, 0, 1};
        for (int i : offset) {
            if (String.valueOf(left).length() == String.valueOf(left + i).length()) {
                String leftString = String.valueOf(left + i);
                String temp = leftString + reverse(leftString.substring(0, len / 2));
                long diff = Math.abs(Long.parseLong(temp) - num);
                if (diff == 0) continue;
                if (diff < minDiff) {
                    minDiff = diff;
                    nearest = Long.parseLong(temp);
                }
            }
        }
        // 检查位数不同的情形
        long pow = (long) Math.pow(10, len - 1);
        // 10000...0001 的情况和 99999 的情况
        long bigger = Long.parseLong(pow + "1");
        long smaller = pow - 1;
        if (Math.abs(num - smaller) <= minDiff) {
            minDiff = Math.abs(num - smaller);
            nearest = smaller;
        }
        if (Math.abs(num - bigger) < minDiff) {
            minDiff = Math.abs(num - bigger);
            nearest = bigger;
        }
        return String.valueOf(nearest);
    }

    String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
