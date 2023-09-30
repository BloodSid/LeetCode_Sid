package leetcode.editor.cn;
//这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, 
//lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。 
//
// 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。 
//
// 返回你最多可以修读的课程数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
//输出：3
//解释：
//这里一共有 4 门课程，但是你最多可以修 3 门：
//首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
//第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
//第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
//第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。 
//
// 示例 2： 
//
// 
//输入：courses = [[1,2]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：courses = [[3,2],[4,3]]
//输出：0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= courses.length <= 10⁴ 
// 1 <= durationi, lastDayi <= 10⁴ 
// 
//
// 👍 581 👎 0


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 课程表 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-09-30 21:33:45 
 */
public class CourseScheduleIiiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int scheduleCourse(int[][] courses) {
        // 按截止时间顺序排列
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        // 记录选用了的课的完成时间
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // 完成所有选中课程的时间
        int end = 0;
        for (int[] c : courses) {
            int d = c[0], l = c[1];
            end += d;
            pq.offer(d);
            // 反悔，把刚选的课程舍去或者把时间更长的课程舍去，
            // l(i-1) <= l(i), end 在这次选择前是小于等于 l(i-1) 的，所以舍去一个课程之后必满足 end <= l(i), 是符合条件的选法
            if (end > l) end -= pq.poll();
        }
        return pq.size();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
