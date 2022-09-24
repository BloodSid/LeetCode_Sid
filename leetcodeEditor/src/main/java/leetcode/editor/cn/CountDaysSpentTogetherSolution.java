package leetcode.editor.cn;
//Alice 和 Bob 计划分别去罗马开会。 
//
// 给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。Alice 会在日期 
//arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。每个字符串
//都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。 
//
// 请你返回 Alice和 Bob 同时在罗马的天数。 
//
// 你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 
//31, 30, 31] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob 
//= "08-19"
//输出：3
//解释：Alice 从 8 月 15 号到 8 月 18 号在罗马。Bob 从 8 月 16 号到 8 月 19 号在罗马，他们同时在罗马的日期为 8 月 1
//6、17 和 18 号。所以答案为 3 。
// 
//
// 示例 2： 
//
// 
//输入：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob 
//= "12-31"
//输出：0
//解释：Alice 和 Bob 没有同时在罗马的日子，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 所有日期的格式均为 "MM-DD" 。 
// Alice 和 Bob 的到达日期都 早于或等于 他们的离开日期。 
// 题目测试用例所给出的日期均为 非闰年 的有效日期。 
// 
// 👍 7 👎 0


/**
 * 统计共同度过的日子数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-24 22:36:40 
 */
public class CountDaysSpentTogetherSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] aa = parse(arriveAlice);
        int[] la = parse(leaveAlice);
        int[] ab = parse(arriveBob);
        int[] lb = parse(leaveBob);
        if (compare(aa, lb) > 0 || compare(ab, la) > 0) return 0;
        int[] start = compare(aa, ab) > 0 ? aa : ab;
        int[] end = compare(la, lb) > 0 ? lb : la;
        int sum = end[1] - start[1] + 1;
        for (int i = start[0]; i < end[0]; i++) {
            sum += days[i];
        }
        return sum;
    }

    int[] parse(String s) {
        return new int[]{Integer.parseInt(s.substring(0, 2)), Integer.parseInt(s.substring(3))};
    }

    int compare(int[] a, int[] b) {
        if (a[0] > b[0]) return 1;
        if (a[0] == b[0]) return a[1] == b[1] ? 0 : a[1] - b[1];
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
