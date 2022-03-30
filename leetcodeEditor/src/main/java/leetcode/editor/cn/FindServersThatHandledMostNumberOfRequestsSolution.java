package leetcode.editor.cn;

import java.util.*;

/**
 * 找到处理最多请求的服务器
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-30 20:30:45 
 */
public class FindServersThatHandledMostNumberOfRequestsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int k;
    private int[] taskCnt;
    private int[] hash;

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        this.k = k;
        taskCnt = new int[k];
        // 此位置上一个任务的结束时间
        hash = new int[k];
        int maxCnt = 0;
        for (int i = 0; i < arrival.length; i++) {
            put(i, arrival[i], arrival[i] + load[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < taskCnt.length; i++) {
            if (taskCnt[i] == maxCnt) {
                list.add(i);
            } else if (taskCnt[i] > maxCnt) {
                maxCnt = taskCnt[i];
                list.clear();
                list.add(i);
            }
        }
        return list;
    }

    void put(int key, int arrival, int leave) {
        for (int i = 0; i < k; i++) {
            int idx = (key + i) % k;
            if (hash[idx] <= arrival) {
                hash[idx] = leave;
                ++taskCnt[idx];
                break;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
