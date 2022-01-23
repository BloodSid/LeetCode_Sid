package leetcode.editor.cn;

import java.util.*;

/**
 * 表示数值的字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-23 14:40:38
 */
public class BiaoShiShuZhiDeZiFuChuanLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isNumber(String s) {
        char[] arr = s.trim().toCharArray();
        int eIndex = 0;
        for (; eIndex < arr.length; eIndex++) {
            if (arr[eIndex] == 'e' || arr[eIndex] == 'E') {
                break;
            }
        }
        if (eIndex == arr.length) {
            return isInteger(arr, 0, arr.length - 1) || isFraction(arr, 0, arr.length - 1);
        } else {
            return (isInteger(arr, 0, eIndex - 1) || isFraction(arr, 0, eIndex - 1))
                    && isInteger(arr, eIndex + 1, arr.length - 1);
        }
    }

    private boolean isFraction(char[] arr, int start, int end) {
        if (start > end) {
            return false;
        }
        if (arr[start] == '+' || arr[start] == '-') {
            start++;
        }
        // 至少一位数字
        if (start > end) {
            return false;
        }
        int dotIndex = -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] == '.' && dotIndex == -1) {
                dotIndex = i;
                continue;
            }
            if (arr[i] < '0' || arr[i] > '9') {
                return false;
            }
        }
        if (dotIndex == -1) {
            return false;
        }
        int preDot = dotIndex - start;
        int postDot = end - dotIndex;
        return preDot >= 1 || postDot >= 1;
    }

    private boolean isInteger(char[] arr, int start, int end) {
        if (start > end) {
            return false;
        }
        if (arr[start] == '+' || arr[start] == '-') {
            start++;
        }
        // 至少一位数字
        if (start > end) {
            return false;
        }
        for (; start <= end; start++) {
            if (arr[start] < '0' || arr[start] > '9') {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
