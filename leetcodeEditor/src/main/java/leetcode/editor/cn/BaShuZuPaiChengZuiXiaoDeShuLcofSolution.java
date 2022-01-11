package leetcode.editor.cn;

import java.util.*;

/**
 * 把数组排成最小的数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-11 22:23:48
 */
public class BaShuZuPaiChengZuiXiaoDeShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, this::compare);
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    int compare(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            int diff = s1.charAt(i) - s2.charAt(i);
            if (diff < 0) {
                return -1;
            } else if (diff > 0) {
                return 1;
            }
        }
        if (len1 == len2) {
            return 0;
        }
        // 两个数前面的数字一致，但是长度不一，需要把长的那个截短
        if (len1 == minLen) {
            s2 = s2.substring(minLen);
        } else {
            s1 = s1.substring(minLen);
        }
        return compare(s1, s2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
