package leetcode.editor.cn;
//可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
// 
// 'A'：Absent，缺勤 
// 'L'：Late，迟到 
// 'P'：Present，到场 
// 
//
// 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励： 
//
// 
// 按 总出勤 计，学生缺勤（'A'）严格 少于两天。 
// 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。 
// 
//
// 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 
//取余 的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：8
//解释：
//有 8 种长度为 2 的记录将被视为可奖励：
//"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL" 
//只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 10101
//输出：183236316
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 105 
// 
// Related Topics 动态规划 
// 👍 212 👎 0


import java.util.*;

/**
 * 学生出勤记录 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-08-18 22:36:55
 */
public class StudentAttendanceRecordIiSolution {
    //ctrl+alt+a 加入版本控制

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int checkRecord(int n) {
            if (n == 1) {
                return 3;
            }
            if (n == 2) {
                return 8;
            }
            // 创建所有的状态
            HashMap<String, Integer> map = new HashMap<>();
            String[] str = {"PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"};
            int value = 0;
            for (int i = 0; i < str.length; i++) {
                if (!str[i].contains("A")) {
                    map.put(0 + str[i], value++);
                }
                map.put(1 + str[i], value++);
            }
            final int MAX_INT = 1000000007;
            // 初始化 dp[i][j]表示i状态的j长度的出勤状况数量
            int[][] dp = new int[map.size()][n];
            for (String s : str) {
                if (s.contains("A")) {
                    dp[map.get(1 + s)][1] = 1;
                } else {
                    dp[map.get(0 + s)][1] = 1;
                }
            }
            char[] status = "PLA".toCharArray();
            HashMap<String, List<String>> statusMap = new HashMap<>();
            for (char now : status) {
                for (String pre : map.keySet()) {
                    String preAndNow = pre + now;
                    if (now == 'A') {
                        preAndNow = (char) (preAndNow.charAt(0) + 1) + preAndNow.substring(1);
                    }
                    // 若有两个A,或有3个连续的L,则不计入
                    if (preAndNow.charAt(0) != '2' && !preAndNow.substring(1).equals("LLL")) {
                        preAndNow = preAndNow.charAt(0) + preAndNow.substring(2);
                        if (statusMap.get(preAndNow) == null) {
                            statusMap.put(preAndNow, new ArrayList<>());
                        }
                        statusMap.get(preAndNow).add(pre);
                    }
                }
            }
            for (int j = 2; j < dp[0].length; j++) {
                for (String nowStatus : map.keySet()) {
                    List<String> pre = statusMap.get(nowStatus);
                    for (String preStatus : pre) {
                        dp[map.get(nowStatus)][j] = (dp[map.get(nowStatus)][j] + dp[map.get(preStatus)][j - 1]) % MAX_INT;
                    }
                }
            }
            long sum = 0;
            for (int i = 0; i < dp.length; i++) {
                sum += dp[i][n - 1];
            }
            return (int) (sum % MAX_INT);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
