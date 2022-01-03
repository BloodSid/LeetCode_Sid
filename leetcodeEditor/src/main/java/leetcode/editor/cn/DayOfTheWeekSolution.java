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

    public String dayOfTheWeek(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return days[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
