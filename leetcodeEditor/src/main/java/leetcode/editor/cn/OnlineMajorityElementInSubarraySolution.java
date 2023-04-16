package leetcode.editor.cn;
//设计一个数据结构，有效地找到给定子数组的 多数元素 。 
//
// 子数组的 多数元素 是在子数组中出现 threshold 次数或次数以上的元素。 
//
// 实现 MajorityChecker 类: 
//
// 
// MajorityChecker(int[] arr) 会用给定的数组 arr 对 MajorityChecker 初始化。 
// int query(int left, int right, int threshold) 返回子数组中的元素 arr[left...right] 至少出
//现 threshold 次数，如果不存在这样的元素则返回 -1。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入:
//["MajorityChecker", "query", "query", "query"]
//[[[1, 1, 2, 2, 1, 1]], [0, 5, 4], [0, 3, 3], [2, 3, 2]]
//输出：
//[null, 1, -1, 2]
//
//解释：
//MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
//majorityChecker.query(0,5,4); // 返回 1
//majorityChecker.query(0,3,3); // 返回 -1
//majorityChecker.query(2,3,2); // 返回 2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 2 * 10⁴ 
// 1 <= arr[i] <= 2 * 10⁴ 
// 0 <= left <= right < arr.length 
// threshold <= right - left + 1 
// 2 * threshold > right - left + 1 
// 调用 query 的次数最多为 10⁴ 
// 
//
// 👍 103 👎 0


/**
 * 子数组中占绝大多数的元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-16 11:20:45 
 */
public class OnlineMajorityElementInSubarraySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class MajorityChecker {

    private final int[] arr;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }
    
    public int query(int left, int right, int threshold) {
        int element = 0;
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (cnt == 0) {
                element = arr[i];
                cnt++;
            } else if (arr[i] == element) {
                cnt++;
            } else {
                cnt--;
            }
        }
        cnt = 0;
        for (int i = left; i <= right; i++) {
            if (arr[i] == element) cnt++;
        }
        return cnt >= threshold ? element : -1;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
