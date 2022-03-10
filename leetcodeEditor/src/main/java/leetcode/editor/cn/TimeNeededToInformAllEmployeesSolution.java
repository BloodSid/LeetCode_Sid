package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 通知所有员工所需的时间
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-09 17:06:37 
 */
public class TimeNeededToInformAllEmployeesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] time;
    private int[] manager;
    private int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.manager = manager;
        this.informTime = informTime;
        int minutes = 0;
        time = new int[n];
        Arrays.fill(time, -1);
        for (int i = 0; i < n; i++) {
            minutes = Math.max(minutes, dfs(i));
        }
        return minutes;
    }

    int dfs(int i) {
        if (i == -1) return 0;
        if (time[i] == -1) {
            time[i] = informTime[i] + dfs(manager[i]);
        }
        return time[i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
