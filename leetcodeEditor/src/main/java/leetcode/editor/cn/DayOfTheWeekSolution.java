package leetcode.editor.cn;

import java.util.*;

/**
 * 一周中的第几天
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-03 12:53:30
 */
public class DayOfTheWeekSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        // 1970年12月31日是星期四
        int index = 4;
        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                index += 366;
            } else {
                index += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            if (i == 2 && isLeapYear(year)) {
                index++;
            }
            index += months[i];
        }
        index += day;
        return days[index % 7];
    }

    boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                return true;
            } else {
                return false;
            }
        }
        return year % 4 == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
