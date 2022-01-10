package leetcode.editor.cn;

import java.util.*;

/**
 * 累加数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-10 09:41:31
 */
public class AdditiveNumberSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAdditiveNumber(String num) {
        // 枚举前两个数字 max(i, j) <= len - i - j
        int len = num.length();
        for (int i = 1; i <= len / 2; i++) {
            int limit = len - 2 * i;
            if (num.charAt(i) == '0') {
                limit = Math.min(limit, 1);
            }
            for (int j = 1; j <= limit; j++) {
                String s1 = num.substring(0, i);
                String s2 = num.substring(i, i + j);
                String s3 = add(s1, s2);
                int toffset = i + j;
                while (toffset < len && num.startsWith(s3, toffset)) {
                    toffset += s3.length();
                    s1 = s2;
                    s2 = s3;
                    s3 = add(s1, s2);
                }
                if (toffset == len) {
                    return true;
                }
            }
        }
        return false;
    }

    String add(String s1, String s2) {
        if (s2.length() > s1.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        char[] arr = s1.toCharArray();
        int len2 = s2.length();
        int sum = 0;
        for (int i1 = arr.length - 1; i1 >= 0; i1--) {
            int i2 = len2 - arr.length + i1;
            if (i2 >= 0) {
                sum += s2.charAt(i2) - '0';
            }
            sum += arr[i1] - '0';
            arr[i1] = (char) (sum % 10 + '0');
            sum /= 10;
        }
        StringBuilder sb = sum == 0 ? new StringBuilder() : new StringBuilder("1");
        sb.append(arr);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
