package leetcode.editor.cn;

import java.util.*;

/**
 * 最小时间差
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-18 11:50:46
 */
public class MinimumTimeDifferenceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int MINUTES_IN_AN_HOUR = 60;
    int MINUTES_IN_A_DAY = 60 * 24;

    public int findMinDifference(List<String> timePoints) {
        timePoints.sort(String::compareTo);
        String pre = timePoints.get(timePoints.size() - 1);
        int min = Integer.MAX_VALUE;
        for (String timePoint : timePoints) {
            int diff = Math.abs(diff(pre, timePoint));
            diff = Math.min(diff, MINUTES_IN_A_DAY - diff);
            min = Math.min(diff, min);
            pre = timePoint;
        }
        return min;
    }

    // 以分钟表示的时间差，正数表示a先b后
    int diff(String a, String b) {
        if (a.equals(b)) {
            return 0;
        }
        int[] pa = parser(a);
        int[] pb = parser(b);
        return (pb[0] - pa[0]) * MINUTES_IN_AN_HOUR + pb[1] - pa[1];
    }

    // 时间字符串转数组{h,m}
    int[] parser(String s) {
        int[] time = new int[2];
        time[0] = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
        time[1] = (s.charAt(3) - '0') * 10 + s.charAt(4) - '0';
        return time;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
